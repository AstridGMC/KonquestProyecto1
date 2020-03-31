package Backend.FlexYCup;
import java_cup.runtime.* ;
import java_cup.runtime.Symbol;
import Backend.FlexYCup.sym;
import java.util.ArrayList;

/*--------------2 Declaraciones ------------*/
%%

%public 
%class AnalizadorLexico 
%cupdebug
%column
%line 
%cup 
%char
%full
%unicode

D = [0-9]+
LetraS = [A-Za-z|Ñ|ñ]
alphaNum   =  [A-Z|a-z|0-9|Ñ|ñ]
Letra = [A-Za-z]
Signo = [_@*#+-]
Comilla = [\"]
//enBlanco = [ \t\n| ]+
 //SaltoDeLinea = \r|\r\n
caracEsp =[_&$]
carac2 = [_&]

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private Symbol symbol(int type, Object value, int fila, int columna) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    ArrayList<String> nombrePlanetas = new ArrayList();
%}

%%
<YYINITIAL> {
//documento jason
    ("FACIL")                                                         {System.out.println( "1... " + yytext());return symbol(sym.FACIL, yytext(), yyline, yycolumn);}
    ("DIFICIL")                                                       {System.out.println( "2..." +  yytext());return symbol(sym.DIFICIL, yytext(), yyline, yycolumn);}
    ("HUMANO")                                                        {System.out.println( "3... " + yytext());return symbol(sym.HUMANO, yytext(), yyline, yycolumn);}
    ("MAPA"|{Comilla} "MAPA" {Comilla})                               {System.out.println( "4... " +  yytext());return symbol(sym.MAPA, yytext(), yyline, yycolumn);}
    ("JUGADORES"|{Comilla}"JUGADORES"{Comilla})                       {System.out.println( "5... " +  yytext());return symbol(sym.JUGADORES, yytext(), yyline, yycolumn);}
    ("PLANETAS_NEUTRALES"|{Comilla} "PLANETAS_NEUTRALES"{Comilla})    {System.out.println( "6... " +  yytext());return symbol(sym.PLANETASNEUTRALES, yytext(), yyline, yycolumn);}
    ("PLANETAS"|{Comilla} "PLANETAS" {Comilla})                       {System.out.println( "7... " +  yytext());return symbol(sym.PLANETAS, yytext(), yyline, yycolumn);}
    ("tipo"|{Comilla} "tipo" {Comilla})                               {System.out.println( "8... " +  yytext());return symbol(sym.TIPOJUGADORid, yytext(), yyline, yycolumn);}    
    ("planetas"|{Comilla} "planetas" {Comilla})                       {System.out.println( "9... " +  yytext());return symbol(sym.PLANETASid, yytext(), yyline, yycolumn);}
    ("nombre"|{Comilla} "nombre" {Comilla})                           {System.out.println( "10... " +  yytext());return symbol(sym.NOMBREid, yytext(), yyline, yycolumn);}
    ("naves"|{Comilla}"naves"{Comilla})                               {System.out.println( "11... " +  yytext());return symbol(sym.NAVESid, yytext(), yyline, yycolumn);}
    ("porcentajeMuertes"|{Comilla}"porcentajeMuertes"{Comilla})       {System.out.println( "12... " +  yytext());return symbol(sym.PORMUERTESid, yytext(), yyline, yycolumn);}
    ("alAzar"|{Comilla}"alAzar"{Comilla})                             {System.out.println( "13... " +  yytext());return symbol(sym.ALAZARid, yytext(), yyline, yycolumn);}
    ("id"|{Comilla}"id"{Comilla})                                     {System.out.println( "14... " +  yytext());return symbol(sym.IDid, yytext(), yyline, yycolumn);}
    ("tamaño"|{Comilla}"tamaño"{Comilla})                             {System.out.println( "15... " +  yytext());return symbol(sym.TAMAÑOid, yytext(), yyline, yycolumn);}
    ("filas"|{Comilla}"filas"{Comilla})                               {System.out.println( "16... " +  yytext());return symbol(sym.FILASid, yytext(), yyline, yycolumn);}
    ("columnas"|{Comilla}"columnas"{Comilla})                         {System.out.println( "17... " +  yytext());return symbol(sym.COLUMNASid, yytext(), yyline, yycolumn);}
    ("planetasNeutrales"|{Comilla}"planetasNeutrales"{Comilla})       {System.out.println( "18... " +  yytext());return symbol(sym.PLANETASNEUTRALESid, yytext(), yyline, yycolumn);}
    ("mapaCiego"|{Comilla}"mapaCiego"{Comilla})                       {System.out.println( "19... " +  yytext());return symbol(sym.MAPACIEGOid, yytext(), yyline, yycolumn);}
    ("acumular"|{Comilla}"acumular"{Comilla})                         {System.out.println( "20... " +  yytext());return symbol(sym.ACUMULARid, yytext(), yyline, yycolumn);}
    ("NEUTRALES"|{Comilla}"NEUTRALES"{Comilla})                       {System.out.println( "21... " +  yytext());return symbol(sym.NEUTRALES, yytext(), yyline, yycolumn);}
    ("mostrarNaves"|{Comilla}"mostrarNaves"{Comilla})                {System.out.println( "22... " +  yytext());return symbol(sym.MOSTRARNAVESid, yytext(), yyline, yycolumn);}
    ("mostrarEstadisticas"|{Comilla}"mostrarEstadisticas"{Comilla})   {System.out.println( "23... " +  yytext());return symbol(sym.MOSTRARESTADISTICASid, yytext(), yyline, yycolumn);}
    ("produccion"|{Comilla}"produccion"{Comilla})                     {System.out.println( "24... " +  yytext());return symbol(sym.PRODUCCIONid, yytext(), yyline, yycolumn);}
    ("finalizacion"|{Comilla}"finalizacion"{Comilla})                 {System.out.println( "25... " +  yytext());return symbol(sym.FINALIZACIONid, yytext(), yyline, yycolumn);}
    ("true"|"TRUE")                                         {System.out.println( "35..." +  yytext());return symbol(sym.TRUE, yytext(), yyline, yycolumn);}
    ("false"|"FALSE")                                       {System.out.println( "36..." +  yytext());return symbol(sym.FALSE, yytext(), yyline, yycolumn);}
    "]"                                                     {System.out.println( "26... " +  yytext());return symbol(sym.CORCHETECIERRA);}
    "["                                                     {System.out.println( "27...."+ yytext() ); return symbol(sym.CORCHETEABRE);}
    ("{")                                                   {System.out.println( "28.... "+ yytext() ); return symbol(sym.ABRECORCHETE, yytext(), yyline, yycolumn);}
    ("}")                                                   {System.out.println( "29.... "+ yytext() );return symbol(sym.CIERRACORCHETE, yytext(), yyline, yycolumn);}
    ":"                                                     {System.out.println( "30..." +  yytext());return symbol(sym.DOSPUNTOS, yytext(), yyline, yycolumn);}
    ({D})+                                                  {System.out.println( "40..." +  yytext());return symbol(sym.ENTERO , yytext(), yyline, yycolumn);}
    {Comilla}                                               {System.out.println( "31..." +  yytext());return symbol(sym.COMILLA, yytext(), yyline, yycolumn);}
    ","                                                     {System.out.println( "32..." +  yytext());return symbol(sym.COMA, yytext(), yyline, yycolumn);}
   //({LetraS}{1,3})  {System.out.println( "33..." +  yytext());return symbol(sym.IDPLANETA, yytext(), yyline, yycolumn);}
    ({LetraS}({alphaNum}{1,9})|({LetraS}|{carac2})({alphaNum}|{caracEsp})+)                             {System.out.println( "39..." +  yytext());return symbol(sym.ID, yytext(), yyline, yycolumn);}
    (0".")({D}+)                                            {System.out.println( "34..." +  yytext());return symbol(sym.NUMMUERTES, yytext(), yyline, yycolumn);}
    //{ID}                                                  {System.out.println( "37..." +  yytext());return symbol(sym.ID, yytext(), yyline, yycolumn);}
    ({LetraS}|{carac2})({alphaNum}|{caracEsp})* {System.out.println( "38..." +  yytext());return symbol(sym.IDMAPA, yytext(), yyline, yycolumn);}
    (\n|\t|\r|\r\n)+ {/*IGNORAR*/}
    (" ")+ {System.out.println("espacio");}
    //({SaltoDeLinea})+ {System.out.println( "salto:" );/*IGNORAR*/}
    .           {System.out.println( "Caracter no reconocido: "+ yytext() );}
}