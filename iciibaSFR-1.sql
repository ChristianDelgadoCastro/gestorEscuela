CREATE DATABASE iciibaSFR;
USE iciibaSFR
GO
 IF NOT EXISTS(SELECT * FROM sys.schemas WHERE [name] = N'iciibaSFR')      
     EXEC (N'CREATE SCHEMA iciibaSFR')                                   
 GO                                                               

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'alumnos'  AND sc.name = N'iciibaSFR'  AND type in (N'U'))
BEGIN

  DECLARE @drop_statement nvarchar(500)

  DECLARE drop_cursor CURSOR FOR
      SELECT 'alter table '+quotename(schema_name(ob.schema_id))+
      '.'+quotename(object_name(ob.object_id))+ ' drop constraint ' + quotename(fk.name) 
      FROM sys.objects ob INNER JOIN sys.foreign_keys fk ON fk.parent_object_id = ob.object_id
      WHERE fk.referenced_object_id = 
          (
             SELECT so.object_id 
             FROM sys.objects so JOIN sys.schemas sc
             ON so.schema_id = sc.schema_id
             WHERE so.name = N'alumnos'  AND sc.name = N'iciibaSFR'  AND type in (N'U')
           )

  OPEN drop_cursor

  FETCH NEXT FROM drop_cursor
  INTO @drop_statement

  WHILE @@FETCH_STATUS = 0
  BEGIN
     EXEC (@drop_statement)

     FETCH NEXT FROM drop_cursor
     INTO @drop_statement
  END

  CLOSE drop_cursor
  DEALLOCATE drop_cursor

  DROP TABLE [iciibaSFR].[alumnos]
END 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE 
[iciibaSFR].[alumnos]
(
   [numControl] int  NOT NULL,
   [nombre] nvarchar(50)  NULL,
   [apellidos] nvarchar(50)  NULL,
   [telefono] nvarchar(20)  NULL
)
WITH (DATA_COMPRESSION = NONE)
GO
BEGIN TRY
    EXEC sp_addextendedproperty
        N'MS_SSMA_SOURCE', N'iciibaSFR.alumnos',
        N'SCHEMA', N'iciibaSFR',
        N'TABLE', N'alumnos'
END TRY
BEGIN CATCH
    IF (@@TRANCOUNT > 0) ROLLBACK
    PRINT ERROR_MESSAGE()
END CATCH
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'alumnos_grupo'  AND sc.name = N'iciibaSFR'  AND type in (N'U'))
BEGIN

  DECLARE @drop_statement nvarchar(500)

  DECLARE drop_cursor CURSOR FOR
      SELECT 'alter table '+quotename(schema_name(ob.schema_id))+
      '.'+quotename(object_name(ob.object_id))+ ' drop constraint ' + quotename(fk.name) 
      FROM sys.objects ob INNER JOIN sys.foreign_keys fk ON fk.parent_object_id = ob.object_id
      WHERE fk.referenced_object_id = 
          (
             SELECT so.object_id 
             FROM sys.objects so JOIN sys.schemas sc
             ON so.schema_id = sc.schema_id
             WHERE so.name = N'alumnos_grupo'  AND sc.name = N'iciibaSFR'  AND type in (N'U')
           )

  OPEN drop_cursor

  FETCH NEXT FROM drop_cursor
  INTO @drop_statement

  WHILE @@FETCH_STATUS = 0
  BEGIN
     EXEC (@drop_statement)

     FETCH NEXT FROM drop_cursor
     INTO @drop_statement
  END

  CLOSE drop_cursor
  DEALLOCATE drop_cursor

  DROP TABLE [iciibaSFR].[alumnos_grupo]
END 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE 
[iciibaSFR].[alumnos_grupo]
(
   [id] int IDENTITY(37, 1)  NOT NULL,
   [numControlGrupo] nvarchar(15)  NULL,
   [numControlAlumno] int  NULL,
   [nombreAlumno] nvarchar(50)  NULL,
   [apellidosAlumno] nvarchar(50)  NULL,
   [numControlAsignatura] int  NULL,
   [calificaciones] nvarchar(50)  NULL
)
WITH (DATA_COMPRESSION = NONE)
GO
BEGIN TRY
    EXEC sp_addextendedproperty
        N'MS_SSMA_SOURCE', N'iciibaSFR.alumnos_grupo',
        N'SCHEMA', N'iciibaSFR',
        N'TABLE', N'alumnos_grupo'
END TRY
BEGIN CATCH
    IF (@@TRANCOUNT > 0) ROLLBACK
    PRINT ERROR_MESSAGE()
END CATCH
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'asignaturas'  AND sc.name = N'iciibaSFR'  AND type in (N'U'))
BEGIN

  DECLARE @drop_statement nvarchar(500)

  DECLARE drop_cursor CURSOR FOR
      SELECT 'alter table '+quotename(schema_name(ob.schema_id))+
      '.'+quotename(object_name(ob.object_id))+ ' drop constraint ' + quotename(fk.name) 
      FROM sys.objects ob INNER JOIN sys.foreign_keys fk ON fk.parent_object_id = ob.object_id
      WHERE fk.referenced_object_id = 
          (
             SELECT so.object_id 
             FROM sys.objects so JOIN sys.schemas sc
             ON so.schema_id = sc.schema_id
             WHERE so.name = N'asignaturas'  AND sc.name = N'iciibaSFR'  AND type in (N'U')
           )

  OPEN drop_cursor

  FETCH NEXT FROM drop_cursor
  INTO @drop_statement

  WHILE @@FETCH_STATUS = 0
  BEGIN
     EXEC (@drop_statement)

     FETCH NEXT FROM drop_cursor
     INTO @drop_statement
  END

  CLOSE drop_cursor
  DEALLOCATE drop_cursor

  DROP TABLE [iciibaSFR].[asignaturas]
END 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE 
[iciibaSFR].[asignaturas]
(
   [numControlAsignatura] int IDENTITY(12, 1)  NOT NULL,
   [nombreAsignatura] nvarchar(50)  NULL
)
WITH (DATA_COMPRESSION = NONE)
GO
BEGIN TRY
    EXEC sp_addextendedproperty
        N'MS_SSMA_SOURCE', N'iciibaSFR.asignaturas',
        N'SCHEMA', N'iciibaSFR',
        N'TABLE', N'asignaturas'
END TRY
BEGIN CATCH
    IF (@@TRANCOUNT > 0) ROLLBACK
    PRINT ERROR_MESSAGE()
END CATCH
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'grupo'  AND sc.name = N'iciibaSFR'  AND type in (N'U'))
BEGIN

  DECLARE @drop_statement nvarchar(500)

  DECLARE drop_cursor CURSOR FOR
      SELECT 'alter table '+quotename(schema_name(ob.schema_id))+
      '.'+quotename(object_name(ob.object_id))+ ' drop constraint ' + quotename(fk.name) 
      FROM sys.objects ob INNER JOIN sys.foreign_keys fk ON fk.parent_object_id = ob.object_id
      WHERE fk.referenced_object_id = 
          (
             SELECT so.object_id 
             FROM sys.objects so JOIN sys.schemas sc
             ON so.schema_id = sc.schema_id
             WHERE so.name = N'grupo'  AND sc.name = N'iciibaSFR'  AND type in (N'U')
           )

  OPEN drop_cursor

  FETCH NEXT FROM drop_cursor
  INTO @drop_statement

  WHILE @@FETCH_STATUS = 0
  BEGIN
     EXEC (@drop_statement)

     FETCH NEXT FROM drop_cursor
     INTO @drop_statement
  END

  CLOSE drop_cursor
  DEALLOCATE drop_cursor

  DROP TABLE [iciibaSFR].[grupo]
END 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE 
[iciibaSFR].[grupo]
(
   [idGrupo] int IDENTITY(9, 1)  NOT NULL,
   [numControlGrupo] nvarchar(15)  NULL,
   [nombreGrupo] nvarchar(50)  NULL,
   [numControlAsignatura] int  NULL
)
WITH (DATA_COMPRESSION = NONE)
GO
BEGIN TRY
    EXEC sp_addextendedproperty
        N'MS_SSMA_SOURCE', N'iciibaSFR.grupo',
        N'SCHEMA', N'iciibaSFR',
        N'TABLE', N'grupo'
END TRY
BEGIN CATCH
    IF (@@TRANCOUNT > 0) ROLLBACK
    PRINT ERROR_MESSAGE()
END CATCH
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'usuarios'  AND sc.name = N'iciibaSFR'  AND type in (N'U'))
BEGIN

  DECLARE @drop_statement nvarchar(500)

  DECLARE drop_cursor CURSOR FOR
      SELECT 'alter table '+quotename(schema_name(ob.schema_id))+
      '.'+quotename(object_name(ob.object_id))+ ' drop constraint ' + quotename(fk.name) 
      FROM sys.objects ob INNER JOIN sys.foreign_keys fk ON fk.parent_object_id = ob.object_id
      WHERE fk.referenced_object_id = 
          (
             SELECT so.object_id 
             FROM sys.objects so JOIN sys.schemas sc
             ON so.schema_id = sc.schema_id
             WHERE so.name = N'usuarios'  AND sc.name = N'iciibaSFR'  AND type in (N'U')
           )

  OPEN drop_cursor

  FETCH NEXT FROM drop_cursor
  INTO @drop_statement

  WHILE @@FETCH_STATUS = 0
  BEGIN
     EXEC (@drop_statement)

     FETCH NEXT FROM drop_cursor
     INTO @drop_statement
  END

  CLOSE drop_cursor
  DEALLOCATE drop_cursor

  DROP TABLE [iciibaSFR].[usuarios]
END 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE 
[iciibaSFR].[usuarios]
(
   [id_usuario] int IDENTITY(3, 1)  NOT NULL,
   [nombre] nvarchar(253)  NOT NULL,
   [email] nvarchar(253)  NOT NULL,
   [telefono] nvarchar(253)  NOT NULL,
   [username] nvarchar(253)  NOT NULL,
   [password] nvarchar(253)  NOT NULL,
   [tipo_nivel] nvarchar(253)  NOT NULL
)
WITH (DATA_COMPRESSION = NONE)
GO
BEGIN TRY
    EXEC sp_addextendedproperty
        N'MS_SSMA_SOURCE', N'iciibaSFR.usuarios',
        N'SCHEMA', N'iciibaSFR',
        N'TABLE', N'usuarios'
END TRY
BEGIN CATCH
    IF (@@TRANCOUNT > 0) ROLLBACK
    PRINT ERROR_MESSAGE()
END CATCH
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'PK_alumnos_numControl'  AND sc.name = N'iciibaSFR'  AND type in (N'PK'))
ALTER TABLE [iciibaSFR].[alumnos] DROP CONSTRAINT [PK_alumnos_numControl]
 GO



ALTER TABLE [iciibaSFR].[alumnos]
 ADD CONSTRAINT [PK_alumnos_numControl]
   PRIMARY KEY
   CLUSTERED ([numControl] ASC)

GO


USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'PK_alumnos_grupo_id'  AND sc.name = N'iciibaSFR'  AND type in (N'PK'))
ALTER TABLE [iciibaSFR].[alumnos_grupo] DROP CONSTRAINT [PK_alumnos_grupo_id]
 GO



ALTER TABLE [iciibaSFR].[alumnos_grupo]
 ADD CONSTRAINT [PK_alumnos_grupo_id]
   PRIMARY KEY
   CLUSTERED ([id] ASC)

GO


USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'PK_asignaturas_numControlAsignatura'  AND sc.name = N'iciibaSFR'  AND type in (N'PK'))
ALTER TABLE [iciibaSFR].[asignaturas] DROP CONSTRAINT [PK_asignaturas_numControlAsignatura]
 GO



ALTER TABLE [iciibaSFR].[asignaturas]
 ADD CONSTRAINT [PK_asignaturas_numControlAsignatura]
   PRIMARY KEY
   CLUSTERED ([numControlAsignatura] ASC)

GO


USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'PK_grupo_idGrupo'  AND sc.name = N'iciibaSFR'  AND type in (N'PK'))
ALTER TABLE [iciibaSFR].[grupo] DROP CONSTRAINT [PK_grupo_idGrupo]
 GO



ALTER TABLE [iciibaSFR].[grupo]
 ADD CONSTRAINT [PK_grupo_idGrupo]
   PRIMARY KEY
   CLUSTERED ([idGrupo] ASC)

GO


USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'PK_usuarios_id_usuario'  AND sc.name = N'iciibaSFR'  AND type in (N'PK'))
ALTER TABLE [iciibaSFR].[usuarios] DROP CONSTRAINT [PK_usuarios_id_usuario]
 GO



ALTER TABLE [iciibaSFR].[usuarios]
 ADD CONSTRAINT [PK_usuarios_id_usuario]
   PRIMARY KEY
   CLUSTERED ([id_usuario] ASC)

GO


USE iciibaSFR
GO
IF EXISTS (
       SELECT * FROM sys.objects  so JOIN sys.indexes si
       ON so.object_id = si.object_id
       JOIN sys.schemas sc
       ON so.schema_id = sc.schema_id
       WHERE so.name = N'grupo'  AND sc.name = N'iciibaSFR'  AND si.name = N'idx_numControlGrupo' AND so.type in (N'U'))
   DROP INDEX [idx_numControlGrupo] ON [iciibaSFR].[grupo] 
GO
CREATE NONCLUSTERED INDEX [idx_numControlGrupo] ON [iciibaSFR].[grupo]
(
   [numControlGrupo] ASC
)
WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF) ON [PRIMARY] 
GO
GO

USE iciibaSFR
GO
IF EXISTS (
       SELECT * FROM sys.objects  so JOIN sys.indexes si
       ON so.object_id = si.object_id
       JOIN sys.schemas sc
       ON so.schema_id = sc.schema_id
       WHERE so.name = N'alumnos_grupo'  AND sc.name = N'iciibaSFR'  AND si.name = N'numControlAlumno' AND so.type in (N'U'))
   DROP INDEX [numControlAlumno] ON [iciibaSFR].[alumnos_grupo] 
GO
CREATE NONCLUSTERED INDEX [numControlAlumno] ON [iciibaSFR].[alumnos_grupo]
(
   [numControlAlumno] ASC
)
WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF) ON [PRIMARY] 
GO
GO

USE iciibaSFR
GO
IF EXISTS (
       SELECT * FROM sys.objects  so JOIN sys.indexes si
       ON so.object_id = si.object_id
       JOIN sys.schemas sc
       ON so.schema_id = sc.schema_id
       WHERE so.name = N'grupo'  AND sc.name = N'iciibaSFR'  AND si.name = N'numControlAsignatura' AND so.type in (N'U'))
   DROP INDEX [numControlAsignatura] ON [iciibaSFR].[grupo] 
GO
CREATE NONCLUSTERED INDEX [numControlAsignatura] ON [iciibaSFR].[grupo]
(
   [numControlAsignatura] ASC
)
WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF) ON [PRIMARY] 
GO
GO

USE iciibaSFR
GO
IF EXISTS (
       SELECT * FROM sys.objects  so JOIN sys.indexes si
       ON so.object_id = si.object_id
       JOIN sys.schemas sc
       ON so.schema_id = sc.schema_id
       WHERE so.name = N'alumnos_grupo'  AND sc.name = N'iciibaSFR'  AND si.name = N'numControlAsignatura' AND so.type in (N'U'))
   DROP INDEX [numControlAsignatura] ON [iciibaSFR].[alumnos_grupo] 
GO
CREATE NONCLUSTERED INDEX [numControlAsignatura] ON [iciibaSFR].[alumnos_grupo]
(
   [numControlAsignatura] ASC
)
WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF) ON [PRIMARY] 
GO
GO

USE iciibaSFR
GO
IF EXISTS (
       SELECT * FROM sys.objects  so JOIN sys.indexes si
       ON so.object_id = si.object_id
       JOIN sys.schemas sc
       ON so.schema_id = sc.schema_id
       WHERE so.name = N'alumnos_grupo'  AND sc.name = N'iciibaSFR'  AND si.name = N'numControlGrupo' AND so.type in (N'U'))
   DROP INDEX [numControlGrupo] ON [iciibaSFR].[alumnos_grupo] 
GO
CREATE NONCLUSTERED INDEX [numControlGrupo] ON [iciibaSFR].[alumnos_grupo]
(
   [numControlGrupo] ASC
)
WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF) ON [PRIMARY] 
GO
GO

USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'alumnos_grupo$alumnos_grupo_ibfk_1'  AND sc.name = N'iciibaSFR'  AND type in (N'F'))
ALTER TABLE [iciibaSFR].[alumnos_grupo] DROP CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_1]
 GO


/* 
*   SSMA error messages:
*   M2SS0015: Foreign Key is not Primary key or Unique key in the referenced table


ALTER TABLE [iciibaSFR].[alumnos_grupo]
 ADD CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_1]
 FOREIGN KEY 
   ([numControlGrupo])
 REFERENCES 
   [iciibaSFR].[iciibaSFR].[grupo]     ([numControlGrupo])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

*/

GO

IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'alumnos_grupo$alumnos_grupo_ibfk_2'  AND sc.name = N'iciibaSFR'  AND type in (N'F'))
ALTER TABLE [iciibaSFR].[alumnos_grupo] DROP CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_2]
 GO



ALTER TABLE [iciibaSFR].[alumnos_grupo]
 ADD CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_2]
 FOREIGN KEY 
   ([numControlAlumno])
 REFERENCES 
   [iciibaSFR].[iciibaSFR].[alumnos]     ([numControl])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

GO

IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'alumnos_grupo$alumnos_grupo_ibfk_3'  AND sc.name = N'iciibaSFR'  AND type in (N'F'))
ALTER TABLE [iciibaSFR].[alumnos_grupo] DROP CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_3]
 GO



ALTER TABLE [iciibaSFR].[alumnos_grupo]
 ADD CONSTRAINT [alumnos_grupo$alumnos_grupo_ibfk_3]
 FOREIGN KEY 
   ([numControlAsignatura])
 REFERENCES 
   [iciibaSFR].[iciibaSFR].[asignaturas]     ([numControlAsignatura])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

GO


USE iciibaSFR
GO
IF EXISTS (SELECT * FROM sys.objects so JOIN sys.schemas sc ON so.schema_id = sc.schema_id WHERE so.name = N'grupo$grupo_ibfk_1'  AND sc.name = N'iciibaSFR'  AND type in (N'F'))
ALTER TABLE [iciibaSFR].[grupo] DROP CONSTRAINT [grupo$grupo_ibfk_1]
 GO



ALTER TABLE [iciibaSFR].[grupo]
 ADD CONSTRAINT [grupo$grupo_ibfk_1]
 FOREIGN KEY 
   ([numControlAsignatura])
 REFERENCES 
   [iciibaSFR].[iciibaSFR].[asignaturas]     ([numControlAsignatura])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

GO


USE iciibaSFR
GO
ALTER TABLE  [iciibaSFR].[alumnos]
 ADD DEFAULT NULL FOR [nombre]
GO

ALTER TABLE  [iciibaSFR].[alumnos]
 ADD DEFAULT NULL FOR [apellidos]
GO

ALTER TABLE  [iciibaSFR].[alumnos]
 ADD DEFAULT NULL FOR [telefono]
GO


USE iciibaSFR
GO
ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [numControlGrupo]
GO

ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [numControlAlumno]
GO

ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [nombreAlumno]
GO

ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [apellidosAlumno]
GO

ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [numControlAsignatura]
GO

ALTER TABLE  [iciibaSFR].[alumnos_grupo]
 ADD DEFAULT NULL FOR [calificaciones]
GO


USE iciibaSFR
GO
ALTER TABLE  [iciibaSFR].[asignaturas]
 ADD DEFAULT NULL FOR [nombreAsignatura]
GO


USE iciibaSFR
GO
ALTER TABLE  [iciibaSFR].[grupo]
 ADD DEFAULT NULL FOR [numControlGrupo]
GO

ALTER TABLE  [iciibaSFR].[grupo]
 ADD DEFAULT NULL FOR [nombreGrupo]
GO

ALTER TABLE  [iciibaSFR].[grupo]
 ADD DEFAULT NULL FOR [numControlAsignatura]
GO

