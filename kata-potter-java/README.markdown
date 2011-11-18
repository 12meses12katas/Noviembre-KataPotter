Kata Potter
===========

Soy uno m�s de los que acude a 12meses12katas e intenta desarrollarla haciendo Test Driven
Development. Hace tiempo, un buen compa�ero de trabajo me habl� de la kata Potter, y
me pica la curiosidad por ver lo que aprendo intentando resolverla.

Al principio pens� tratar de hacerla en Ruby para aprender el lenguaje, pero apenas 
la empec� me di cuenta de que aprender Ruby y resolver la kata no me hac�a feliz.
As� que vuelvo a la zona de comfort de Java, donde domino. Despu�s intentar� portarla a
otros lenguajes.

Empiezo como todas las katas, haciendo un test m�nimo que describa los elementos m�s simples.
Antes del verano de 2011 d� un curso de TDD en la UPV. El reto era dar soluci�n a un 
Sudoku, desarroll�ndolo TDD. El curso me revel� que lo m�s importante es dar pasos peque�os.
Cuando pienso en ello, lo comparo con una vez que fui a escalar con otro buen amigo.
Yo no escalo frecuentemente, pero las ganas de subir son m�s fuertes que mi pobr�sima t�cnica.
Trepo a grandes zancadas, sin coordinaci�n entre pies y manos, estir�ndome m�s de la cuenta,
y acabo con brazos y piernas cansados. En cambio, mi amigo sube con una facilidad pasmosa.
Y al observarle escalar por la misma v�a me d� cuenta que �l daba pasos peque�os; sub�a
encontrando apoyos en la v�a casi como si se trataran de pelda�os en una escalera.

De la misma forma abordar� la kata, sin preocuparme de momento de cuestiones complejas como
la optimizaci�n, justamente para confiar en que el problema se doblegar� si voy escribiendo
peque�os test que agreguen c�digo en la direcci�n correcta.

Iteraci�n 1
___________

En la propuesta de la kata se representaba a los libros como simples n�meros del 0 al 4, lo cual
es totalmente v�lido. Sin embargo he optado por dar nombres un poco m�s significativos
a las entidades que intervienen con la esperanza de que me ayude a razonar sobre el problema.

La intenci�n era encontrar un test que obligara a implementar un poco de c�digo que tuviera
posibilidades de convertirse en algo �til, pero los 2 primeros test que escrib� o bien
permit�an una implementaci�n muy simple pero sin visos de futuro o bien ten�a que 
implementar algo mucho m�s sifisticado de lo que ped�a el test.

La idea que hay por detr�s de la primera implementaci�n gira en torno a la idea de una clase
Grupo, que tiene la responsabilidad de agregar un Libro si a�n no est� en el grupo, y en otro
caso lo delega a otro Grupo. Esta recursi�n tambi�n se aprovecha para calcular el precio
y el descuento de cada grupo.

Realmente me queda la sensaci�n de haber hecho mucho m�s c�digo que pruebas, apart�ndome del
TDD y del YAGNI; quiz� despu�s de una refactorizaci�n pueda volver a la buena senda.

Iteraci�n 2
-----------

En esta iteraci�n empec� a cambiar un poco la creaci�n de la Cesta de libros. Estaba usando
arrays a secas instanciados dentro de la propia clase de Test. Mov� todo ese c�digo fuera
de las pruebas, a ra�z de lo cual surgieron algunas clases que van en camino de convertirse
en Factories.

En esta iteraci�n he visto un efecto "rebote" en cuanto a que en princpio cre� algunas
clases como "Cesta" que luego descart� completamente. Mala se�al, seguramente es un indicador
de que estoy adelant�ndome a los test.

He tenido problemas en encontrar test que me guiaran hacia la soluci�n. Los que est�n
propuestos en la Kata me demandaban mucha implementaci�n desde un principio. Exigen mucho
a la "caja negra".

La clase que resolvi� gran parte de los problemas es Grupo. Tiene una aproximaci�n recursiva
que me ahorr� muchas l�nea de c�digo para calcular el precio de los grupos de libros. Pero
es una clase que no surgi� de los test, por eso me lamento un poco no haber encontrado
el conjunto de pruebas adecuado.

Todos los test pasan. Como propon�a la propia kata, he reuido implementar un optimizador
gen�rico, pero creo que al final ser�a lo m�s elegante. La optimizaci�n que hay implementada
es a base de balancear la talla de los grupos. Primero calculo el precio con la agrupaci�n
natural del algoritmo y luego calculo el precio intentando que las tallas de los mismos sean
parecidas. A pesar de que funciona, tiene un efecto secundario grave, porque en casos
devuelve un precio que no correpondo con al grupo tal y como queda despu�s de calcularlo.

Conclusi�n
----------

Es una kata que puede dar mucho de s�, pero la elecci�n de los casos no me ha satisfecho.
Creo que la voy a intentar en otro momento, cuando el problema haya "descansado", 
centrandome en encontrar los tests que conduzcan a la soluci�n de manera mucho m�s simple. 