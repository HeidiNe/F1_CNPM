CREATE PROC sp_checkContract(
	@idDriver1 INT,
	@idDriver2 INT, 
	
	@idTeam INT,
	@entrydate NVARCHAR(20),

	@status NVARCHAR(250) OUT
)
AS 
BEGIN
	DECLARE @nameT NVARCHAR(250);

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

	SELECT @nameT = tblRaceTeam.name FROM tblRaceTeam WHERE tblRaceTeam.id = @idTeam;



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
			SET @status = N'Hợp đồng giữa tay đua ' + @nameDriver1 + N' với đội đua ' + @nameT + N'đã hết.';	
		END
			
	ELSE IF NOT (@entrydate BETWEEN @startTimerCT2 AND @endTimerCT2)
		BEGIN
			SET @status = N'Hợp đồng giữa tay đua ' + @nameDriver2 + N' với đội đua ' + @nameT + N'đã hết.';	
		END
			
	ELSE 
		SET @status = 'success';	
END

DECLARE @status NVARCHAR(250);
EXEC sp_checkContract 5, 8, 4, '2024-05-12', @status OUT;
PRINT(@status);

