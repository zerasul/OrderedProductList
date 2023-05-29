# Prueba técnica Productos Ordenados

[![Java CI with Maven](https://github.com/zerasul/OrderedProductList/actions/workflows/maven.yml/badge.svg)](https://github.com/zerasul/OrderedProductList/actions/workflows/maven.yml)

En este repositorio, puedes encontrar una aplicación de ejemplo con una resolución a una prueba técnica, para devolver un listado de productos ordenados por varios criterios.

En esta aplicación basada en Spring Boot despliega una API REST, que recibe a través de la URL, un nombre de criterio.

Estos criterios de ordenación, se han insertado en una base de datos; además de los productos junto a su Stock.

Para acceder a esta API, puede hacerlo de la siguiente forma:

```
GET http://localhost:8091/api/products/criteria/{criteriaName} 
```

Donde _criteriaName_, es el nombre del criterio para ordenar los productos ordenados por dicho criterio; puedes encontrar dos:

* _sales_: El listado es ordenado por el número de productos vendidos de forma descendente.
* _stock_: El listado es ordenado por Ratio de Stock con respecto a las unidades vendidas.

## Arrancar la aplicación

Para arrancar la aplicación, puede usarse el fichero ```docker-compose.yml```. Puede seguir los siguientes pasos:

1. Compilar y generar el Jar con Maven:

```bash
mvn clean package
```

2. Construir la Imagen

```bash
docker-compose build
```

**NOTA:** Consulte el fichero .env para ver las variables de entorno necesarias.

3. Arrancar la aplicación

```bash
docker-compose up
```

Se arrancará una instancia de Mysql y la propia aplicación.

**NOTA:** En el directorio _data_, hay un script sql por si quiere insertar datos de ejemplo.

También puede usar los tests de integración, usando un contenedor Mysql (Que se arranca automáticamente el iniciar los tests) para probar la aplicación. 

Para lanzar los tests:

```bash
mvn clean test
```
