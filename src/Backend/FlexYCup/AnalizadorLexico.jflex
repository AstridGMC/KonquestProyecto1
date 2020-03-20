package PracticaSQL.Backend.cupAndFlex;
import java_cup.runtime.* ;
import java_cup.runtime.Symbol;
import PracticaSQL.Backend.CUP.sym;
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
%%

D  [0-9]+
LetraS  [A-Z a-z]
ID     [a-z][a-z0-9]*
Letra  [A-Z a-z]
Signo  [_@*#+-]
Comilla  [\"]
enBlanco= [/t|/r|/n|/f]+
caracEsp =[_&$]
carac2 = [_&]

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    ArrayList<String> nombrePlanetas;
%}

%%
//documento jason
"MAPA"                  {return symbol(sym.MAPA, yytext(), yyline, yycolumn);}
"PLANETAS_NEUTRALES"    {return symbol(sym.PLANETASNEUTRALES, yytext(), yyline, yycolumn);}
"PLANETAS"              {return symbol(sym.PLANETAS, yytext(), yyline, yycolumn);}
"nombre"                {return symbol(sym.NOMBREid, yytext(), yyline, yycolumn);}
"naves"                 {return symbol(sym.NAVESid, yytext(), yyline, yycolumn);}
"produccion"            {return symbol(sym.PRODUCCIONid, yytext(), yyline, yycolumn);}
"porcentajeMuertes"     {return symbol(sym.PORMUERTESid, yytext(), yyline, yycolumn);}
"alAzar"                {return symbol(sym.ALAZARid, yytext(), yyline, yycolumn);}
"id"                    {return symbol(sym.IDid, yytext(), yyline, yycolumn);}
"tamaño"                {return symbol(sym.TAMAÑOid, yytext(), yyline, yycolumn);}
"filas"                 {return symbol(sym.FILASid, yytext(), yyline, yycolumn);}
"columnas"              {return symbol(sym.COLUMNASid, yytext(), yyline, yycolumn);}
"planetasNeutrales"     {return symbol(sym.PLANETASNEUTRALESid, yytext(), yyline, yycolumn);}
"mapaCiego"             {return symbol(sym.TAMAÑOid, yytext(), yyline, yycolumn);}
"acumular"              {return symbol(sym.ACUMULARid, yytext(), yyline, yycolumn);}
"NEUTRALES"             {return symbol(sym.NEUTRALES, yytext(), yyline, yycolumn);}
"mostrarNaves"          {return symbol(sym.MOSTRARNAVESid, yytext(), yyline, yycolumn);}
"mostrarEstadisticas"   {return symbol(sym.MOSTRARESTADISTICASid, yytext(), yyline, yycolumn);}
"produccion"            {return symbol(sym.PRODUCCIONid, yytext(), yyline, yycolumn);}
"finalizacion"          {return symbol(sym.FINALIZACIONid, yytext(), yyline, yycolumn);}
("]"|"],")              {return symbol(sym.CORCHETECIERRA);}
"["                     {return symbol(sym.CORCHETEABRE);}
"{"                     {return symbol(sym.ABRECORCHETE, yytext(), yyline, yycolumn);}
("}"|"},")              {return symbol(sym.CIERRACORCHETE, yytext(), yyline, yycolumn);}
":"                     {return symbol(sym.DOSPUNTOS, yytext(), yyline, yycolumn);}



{Comilla}                                               {return symbol(sym.COMILLA, yytext(), yyline, yycolumn);}
","                                                     {return symbol(sym.COMA, yytext(), yyline, yycolumn);}
({LetraS}|{LetraS}{LetraS}|{LetraS}{LetraS}{LetraS})    {return symbol(sym.IDPLANETA, yytext(), yyline, yycolumn);}
(0".")({D}+)                                            {return symbol(sym.NUMMUERTES, yytext(), yyline, yycolumn);}
("true"|"TRUE")                                         {return symbol(sym.TRUE, yytext(), yyline, yycolumn);}
("false"|"FALSE")                                       {return symbol(sym.FALSE, yytext(), yyline, yycolumn);}
{ID}                                                    {return symbol(sym.ID, yytext(), yyline, yycolumn);}
{({LetraS}|{carac2})(({ID})|{caracEsp})}                {retunr symbol(sym.IDMAPA, yytext(), yyline, yycolumn);}
({D})+                                                  {return symbol(sym.ENTERO , yytext(), yyline, yycolumn);}

{enBlanco} {/*IGNORAR*/}
.           printf( "Caracter no reconocido: %s\n", yytext );
