ALTER PROC sp_addEntrys(
	@entrydate DATE,
	@idGP INT,
	@idUser INT,
	@idTeam INT,

	@idDriver1 INT,
	@idDriver2 INT,

	@status NVARCHAR(250) OUTPUT
)
AS
BEGIN
	DECLARE @nameGP NVARCHAR(250);
	DECLARE @nameT NVARCHAR(250);

	SELECT @nameGP = tblGrandPrix.name FROM tblGrandPrix WHERE tblGrandPrix.id = @idGP;
	SELECT @nameT = tblRaceTeam.name FROM tblRaceTeam WHERE tblRaceTeam.id = @idTeam;

	IF EXISTS(	SELECT e.id 
				FROM tblEntry as e
				INNER JOIN tblGrandPrix as gp ON gp.id = e.grandPrixid
				INNER JOIN tblContract as ct ON ct.id = e.contractid
				INNER JOIN tblRaceTeam as t ON t.id = ct.raceteamid
				WHERE gp.id = @idGP AND t.id = @idTeam)

		BEGIN	
			SET @status = N'Đã tồn tại bảng đăng ký thi đấu giữa chặng đua ' + @nameGP + N' với đội đua ' + @nameT;
		END

	ELSE 
		BEGIN 
			DECLARE @idCT1 INT;
			DECLARE @idCT2 INT;

			DECLARE @startTimerCT1 DATE;
			DECLARE @endTimerCT1 DATE;

			DECLARE @startTimerCT2 DATE;
			DECLARE @endTimerCT2 DATE;

			DECLARE @nameDriver1 NVARCHAR(50);
			DECLARE @nameDriver2 NVARCHAR(50);


			SELECT @nameDriver1 = tblDriver.name FROM tblDriver WHERE tblDriver.id = @idDriver1
			SELECT @nameDriver2 = tblDriver.name FROM tblDriver WHERE tblDriver.id = @idDriver2


			SELECT	@idCT1 = tblContract.id, 
					@startTimerCT1 = tblContract.startTime,
					@endTimerCT1 = tblContract.endTime
				FROM tblContract 
				WHERE tblContract.driverid = @idDriver1 AND tblContract.raceteamid = @idTeam;

			SELECT	@idCT2 = tblContract.id, 
					@startTimerCT2 = tblContract.startTime,
					@endTimerCT2 = tblContract.endTime
				FROM tblContract 
				WHERE tblContract.driverid = @idDriver2 AND tblContract.raceteamid = @idTeam;

	

			IF (NOT(@entrydate BETWEEN @startTimerCT1 AND @endTimerCT1)) AND (NOT(@entrydate BETWEEN @startTimerCT2 AND @endTimerCT2))
				BEGIN
					SET @status = N'Hợp đồng giữa hai tay đua ' + @nameDriver1 + ' và ' + @nameDriver2 + N' với đội đua ' + @nameT + N' đã hết.';	
				END
			
			ELSE IF NOT (@entrydate BETWEEN @startTimerCT1 AND @endTimerCT1)
				BEGIN
					SET @status = N'Hợp đồng giữa tay đua ' + @nameDriver1 + N' với đội đua ' + @nameT + N' đã hết.';	
				END
			
			ELSE IF NOT (@entrydate BETWEEN @startTimerCT2 AND @endTimerCT2)
				BEGIN
					SET @status = N'Hợp đồng giữa tay đua ' + @nameDriver2 + N' với đội đua ' + @nameT + N' đã hết.';	
				END
			
			ELSE 
				BEGIN
					DECLARE @idE1 INT;
					DECLARE @idE2 INT;

					SELECT @idE1 = ISNULL(MAX(id), 0) + 1 FROM tblEntry;
					SELECT @idE2 = ISNULL(MAX(id), 0) + 2 FROM tblEntry;

					INSERT INTO [dbo].[tblEntry] VALUES 
					(@idE1, @entrydate, NULL, @idGP, @idUser, @idCT1),
					(@idE2, @entrydate, NULL, @idGP, @idUser, @idCT2)

					SET @status = 'success'
				END
			
		END
END

DECLARE @status NVARCHAR(250) ;
EXEC sp_addEntrys '2024-05-12', 2024006, 101, 4, 5, 7, @status OUT;
PRINT (@status)
