# Lista de Cambios realizados
> Aca se anotan los cambios realizados explicando cualidades de diseño aplicadas :+1:

Cambio  | Cualidad de diseño aplicada
------- | ---------------
Primeramente habíamos creado el método de cercanía en todas las subclases, luego para no repetir código subimos a POI dicho método y redefinimos en la clases correspondientes | Redundancia mínima
Se generó el método distanciaAUnaCoordenada para abstraer más el código y hacerlo más expresivo y declarativo | Abstracción
Eliminamos Dia e Intervalo y dejamos Horario | Mayor simplicidad
Las llamadas a metodos de la misma clase o subclase las hacemos protected | Aporta encapsulamiento
Abstraemos los métodos de dist. y le mandamos lo necesario por parámetro | Abstracción / DRY
Usamos constructores para instanciar objetos que tengan atributos inmutables | Mutaciones controladas
Elimino clase __ServicioBuilder__, y creo metodo de clase _horariosComunes_ | YAGNI

