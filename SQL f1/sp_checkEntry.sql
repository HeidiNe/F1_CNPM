ALTER PROC sp_checkEntry(
	@idGP INT,
	@idTeam INT,

	@status NVARCHAR(250) OUT
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
			SET @status = N'Đã tồn tại bản đăng ký thi đấu giữa chặng đua ' + @nameGP + N'với đội đua ' + @nameT;
		END
	ELSE
		BEGIN
			SET @status = 'success';
		END
END


DECLARE @status NVARCHAR(250);
EXEC sp_checkEntry 2024006, 4, @status OUT;
PRINT(@status);
