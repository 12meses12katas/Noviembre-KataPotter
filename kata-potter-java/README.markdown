Kata Potter
===========

Soy uno más de los que acude a 12meses12katas e intenta desarrollarla haciendo Test Driven
Development. Hace tiempo, un buen compañero de trabajo me habló de la kata Potter, y
me pica la curiosidad por ver lo que aprendo intentando resolverla.

Al principio pensé tratar de hacerla en Ruby para aprender el lenguaje, pero apenas 
la empecé me di cuenta de que aprender Ruby y resolver la kata no me hacía feliz.
Así que vuelvo a la zona de comfort de Java, donde domino. Después intentaré portarla a
otros lenguajes.

Empiezo como todas las katas, haciendo un test mínimo que describa los elementos más simples.
Antes del verano de 2011 dí un curso de TDD en la UPV. El reto era dar solución a un 
Sudoku, desarrollándolo TDD. El curso me reveló que lo más importante es dar pasos pequeños.
Cuando pienso en ello, lo comparo con una vez que fui a escalar con otro buen amigo.
Yo no escalo frecuentemente, pero las ganas de subir son más fuertes que mi pobrísima técnica.
Trepo a grandes zancadas, sin coordinación entre pies y manos, estirándome más de la cuenta,
y acabo con brazos y piernas cansados. En cambio, mi amigo sube con una facilidad pasmosa.
Y al observarle escalar por la misma vía me dí cuenta que él daba pasos pequeños; subía
encontrando apoyos en la vía casi como si se trataran de peldaños en una escalera.

De la misma forma abordaré la kata, sin preocuparme de momento de cuestiones complejas como
la optimización, justamente para confiar en que el problema se doblegará si voy escribiendo
pequeños test que agreguen código en la dirección correcta.

Iteración 1
___________

En la propuesta de la kata se representaba a los libros como simples números del 0 al 4, lo cual
es totalmente válido. Sin embargo he optado por dar nombres un poco más significativos
a las entidades que intervienen con la esperanza de que me ayude a razonar sobre el problema.

La intención era encontrar un test que obligara a implementar un poco de código que tuviera
posibilidades de convertirse en algo útil, pero los 2 primeros test que escribí o bien
permitían una implementación muy simple pero sin visos de futuro o bien tenía que 
implementar algo mucho más sifisticado de lo que pedía el test.

La idea que hay por detrás de la primera implementación gira en torno a la idea de una clase
Grupo, que tiene la responsabilidad de agregar un Libro si aún no está en el grupo, y en otro
caso lo delega a otro Grupo. Esta recursión también se aprovecha para calcular el precio
y el descuento de cada grupo.

Realmente me queda la sensación de haber hecho mucho más código que pruebas, apartándome del
TDD y del YAGNI; quizá después de una refactorización pueda volver a la buena senda.

Iteración 2
-----------

En esta iteración empecé a cambiar un poco la creación de la Cesta de libros. Estaba usando
arrays a secas instanciados dentro de la propia clase de Test. Moví todo ese código fuera
de las pruebas, a raíz de lo cual surgieron algunas clases que van en camino de convertirse
en Factories.

En esta iteración he visto un efecto "rebote" en cuanto a que en princpio creé algunas
clases como "Cesta" que luego descarté completamente. Mala señal, seguramente es un indicador
de que estoy adelantándome a los test.

He tenido problemas en encontrar test que me guiaran hacia la solución. Los que están
propuestos en la Kata me demandaban mucha implementación desde un principio. Exigen mucho
a la "caja negra".

La clase que resolvió gran parte de los problemas es Grupo. Tiene una aproximación recursiva
que me ahorró muchas línea de código para calcular el precio de los grupos de libros. Pero
es una clase que no surgió de los test, por eso me lamento un poco no haber encontrado
el conjunto de pruebas adecuado.

Todos los test pasan. Como proponía la propia kata, he reuido implementar un optimizador
genérico, pero creo que al final sería lo más elegante. La optimización que hay implementada
es a base de balancear la talla de los grupos. Primero calculo el precio con la agrupación
natural del algoritmo y luego calculo el precio intentando que las tallas de los mismos sean
parecidas. A pesar de que funciona, tiene un efecto secundario grave, porque en casos
devuelve un precio que no correpondo con al grupo tal y como queda después de calcularlo.

Conclusión
----------

Es una kata que puede dar mucho de sí, pero la elección de los casos no me ha satisfecho.
Creo que la voy a intentar en otro momento, cuando el problema haya "descansado", 
centrandome en encontrar los tests que conduzcan a la solución de manera mucho más simple. 