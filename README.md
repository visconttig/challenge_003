# Requisitos del Challenge.

## Implementar la HTTP request.
Para obtener la informacion de los libros.

## Mapear / convertir de Json a Java

## Utilizar Spring Data JPA para implementar la persistencia usando PostgreSQL.

## Interactuar con el usuario
El método Main debe implementar la interfaz CommandLineRunner y su método run() donde deberás llamar un método para exhibir el menu. En este método, debes crear un bucle para presentar a tu usuario las opciones de insercion y consulta. El usuario deberá seleccionar un número que corresponderá a la opcion numérica y proporcionar los datos que la aplicación recibirá.

### Required functionality: 
> This first functionality works fetching data from the REST API, not! from the Database.
1. Buscar libro por titulo.
> Search in REST API and save the results to the DB.
> > Don't allow to save duplicate books ::warning::

> Display saved book info:
> - `Title`
> - `Author`
> - `Language`
> - `Number of Downloads`.
 

> From here onwards, work with the already saved to Database info. 
2. Listar libros registrados.
> Same display info as previous one, but for all saved Book entities.
3. Listar autores registrados.
> Display 
> - `Name`
> - `Birth Date`
> - `Death Date`
> - `Books` (As an array / collection).
4. Listar autores vivos en un determinado año.
> Ask the year as input.
> Use the previous `Author` display for each one.
5. Listar libros por idioma.
> Ask language as input:
> - es - Spanish
> - en - English
> - fr - French
> - pt - Portuguese
> - etc.

> Use `Book` display for results.

> Give the user the change to do other things in life... 
6. Opcion salir de la aplicación.