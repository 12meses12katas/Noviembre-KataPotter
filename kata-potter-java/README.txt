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