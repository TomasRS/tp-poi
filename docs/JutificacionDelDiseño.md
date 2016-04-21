# Justificacion del diseño
## Busqueda
Explico los metodos y criterios utilizados en el diseño de sta funcionalidad

__MapaPOI__
- Posee el metodo __buscar__(_palabra_) que filtra los __POI__ que tenga _palabra_ contenida entre sus valores de busqueda.

__POI__
- posee el metodo __contiene__(_palabra_) que se fija con los atributos *string*izados representativos(_nombre, rubro, direccion_).

__Direccion__
- contiene todos los atributos referentes a la direccion, y posee el metodo __posiblesPalabrasClaves__() que retorna una lista de sus atributos *string*izados de sus atributos para ser utilizados por __POI__.
