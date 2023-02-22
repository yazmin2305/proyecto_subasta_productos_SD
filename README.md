# proyecto_subasta_productos_SD

Sistema que permite controlar la subasta de un conjunto de productos.
Hay dos roles, los administradores que gestionan los productos a subastar y determinan que producto subastar, y los clientes quienes pueden ofertar por un producto determinado.

Se desarrollaron 9 servicios web, los cuales se describen a continuación:

Servicio web 1: Permite a los clientes y administradores registrarse en la aplicación, con sus datos personales, login y contraseña.

Servicio web 2: Permite a los clientes y administradores iniciar sesión.

Servicio web 3: Permite a los administradores registrar un producto a ofertar.

Servicio web 4: Permite a los administradores listar los productos a ofertar.

Servicio web 5: Permite a los administradores abrir o cerrar una subasta para un producto en específico a partir de su id.

Servicio web 6: Permite a los clientes listar los productos que se están subastando y los que no se están subastando.

Servicio web 7: Permite consultar los datos del producto en particular.

Servicio web 8: Permite consultar los datos del producto que actualmente se está subastando, y el valor de la oferta actual. Si no hay una subasta abierta aparece un mensaje indicando que no existen subastas abiertas. 

Nota: Mediante un hilo de ejecución alterno se puede consultar cada 4 segundos el servicio web y se refresca la pantalla con el resultado.

Servicio web 9: Permite a un cliente ofrecer una oferta para el producto que actualmente se está subastando. Considerando que la oferta realizada sea mayor que la oferta actual.
