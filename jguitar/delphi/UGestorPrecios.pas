unit UGestorPrecios;

interface

type
  TGestorPrecios = class
  private
    class function GetMaxColeccion(AColecciones: array of Integer): Integer;
    class function GetPrecioMaximoPack(AColecciones: array of Integer): Double;
    class function GetPrecioMaximoAnteriorPack(AColecciones: array of Integer): Double;
    class function GetPrecioRecursivoPack(AColecciones: array of Integer; APack: Integer): Double;
    class function GetPrecioPack(AUnidades: Integer): Double;
  public
    class function Precios(ACesta: array of Integer): Double;
  end;

implementation

uses
  Math, SysUtils;

{ TGestorPrecios }

class function TGestorPrecios.GetMaxColeccion(
  AColecciones: array of Integer): Integer;
  // Devuelve el total de unidades que puede componer una colección
var
  i: Integer;
begin
  Result := 0;

  for i := 0 to 4 do
  begin
    if AColecciones[i] <> 0 then
      Inc(Result);
  end;
end;

class function TGestorPrecios.GetPrecioMaximoPack(AColecciones:
  array of Integer): Double;
  // Realiza los cálculos agrupando entre los packs posibles. Priorizando
  // el número máximo de libros en un pack.
begin
  Result := GetPrecioRecursivoPack(AColecciones, GetMaxColeccion(AColecciones));
end;

class function TGestorPrecios.Precios(ACesta: array of Integer): Double;
  // Se obtiene el mínimo precio posible para una cesta de libros.
  // El precio mínimo se calcula mediante la agrupación máxima en colecciones.
  // O bien, mediante la agrupación anterior a la máxima.
var
  i: Integer;
  Colecciones: array [0 .. 4] of Integer;
begin
  for i := 0 to 4 do
    Colecciones[i] := 0;

  // recorrer libros y agrupar según el título
  for i := 0 to Length(ACesta) - 1 do
    Colecciones[ACesta[i]] := Colecciones[ACesta[i]] + 1;

  Result := Min(GetPrecioMaximoPack(Colecciones),
    GetPrecioMaximoAnteriorPack(Colecciones));
end;

class function TGestorPrecios.GetPrecioMaximoAnteriorPack(
  AColecciones: array of Integer): Double;
  // Obtener el precio de las colecciones agrupando en colecciones pero
  // agrupando al máximo posible - 1, para conseguir mejoras en los descuentos.
var
  UnidadesPack: Integer;
begin
  UnidadesPack := GetMaxColeccion(AColecciones) - 1;
  // Coger al menos 1 libro
  if UnidadesPack < 1 then
    UnidadesPack := 1;

  Result := GetPrecioRecursivoPack(AColecciones, UnidadesPack);
end;

class function TGestorPrecios.GetPrecioPack(AUnidades: Integer): Double;
begin
  case AUnidades of
    0:
      Result := 0;
    1:
      Result := 8;
    2:
      Result := 8 * 2 * 0.95;
    3:
      Result := 8 * 3 * 0.9;
    4:
      Result := 8 * 4 * 0.8;
    5:
      Result := 8 * 5 * 0.75;
  else
    raise Exception.Create('El número de libros tiene que ser entre 1 y 5.');
  end;
end;

class function TGestorPrecios.GetPrecioRecursivoPack(
  AColecciones: array of Integer; APack: Integer): Double;
  // Borrar de las colecciones el pack que vamos a calcular.
  // Se sigue calculando el precio de los restantes recursivamente.
var
  Unidades: Integer;
  i: Integer;
begin
  Unidades := 0;

  // Descontar los libros que forman un pack
  for i := 0 to 4 do
  begin
    if (AColecciones[i] <> 0) and (Unidades < APack) then
    begin
      AColecciones[i] := AColecciones[i] - 1;
      Inc(Unidades);
    end;
  end;
  Result := GetPrecioPack(Unidades);

  // Recursivo
  if MaxIntValue(AColecciones) > 0 then
    Result := Result + GetPrecioMaximoPack(AColecciones);
end;

end.
