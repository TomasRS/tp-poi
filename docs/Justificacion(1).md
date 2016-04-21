# Justificacion del Diseño 

=================================================================================================================================================================================

> Funcionalidad Cercanía
>
Cambio  | Cualidad de diseño aplicada
------- | ---------------
Primeramente habíamos creado el método de cercanía en todas las subclases, luego para no repetir código subimos a POI dicho método y redefinimos en la clases correspondientes | Redundancia mínima
Se generó el método distanciaAUnaCoordenada para abstraer más el código y hacerlo más expresivo y declarativo | Abstracción
Eliminamos Dia e Intervalo y dejamos Horario | Mayor simplicidad
Las llamadas a metodos de la misma clase o subclase las hacemos protected | Aporta encapsulamiento
Abstraemos los métodos de dist. y le mandamos lo necesario por parámetro | Abstracción / DRY
Usamos constructores para instanciar objetos que tengan atributos inmutables | Mutaciones controladas
Elimino clase __ServicioBuilder__, y creo metodo de clase _horariosComunes_ | YAGNI

> Funcionalidad Disponbilidad
>
En cuanto a la disponibilidad tuvimos varias ideas que las fuimos implementando y **refactorizando** a lo largo de estas semanas. Comenzamos haciendo **herencia**, en la cual hicimos una **clase abstracta** (POI)  y de la cual heredaban las 4 clases (banco, CGP, parada de colectivo y local comercial)  el diseño era bastante simple  y funcionaba pero nos fuimos encontrando con varios problemas entre ellos **repetición de lógica**, por lo que decidimos crear 1 clase abstracta mas (EmpresasMultiServicio)  y colocar ahí la lógica repetida.  Comparando  ambos diseños notamos que al tener lógica repetida no era un diseño **extensible** ya que si creaban nuevos objetos que  hagan lo mismo había que repetirlo múltiples veces o si se encontrara un error habría que modificarlo en múltiples lugares, en cambio tener ese método en la clase abstracta minimizaba la redundancia.
Vale aclarar que siempre tuvimos presente la idea de **simplicidad** tanto **KISS** como **YAGNI** pero en este caso nos parecía útil tener esa clase abstracta por lo que la tomamos como una **complejidad esencial**.  
También consideramos que aplicamos un poco la idea de **robustez** al hacer que si se pedía la disponibilidad de un servicio que tanto el banco como la CGP no lo tenía, tire una excepción avisando que ese servicio no existe. 

> Funcionalidad Búsqueda
