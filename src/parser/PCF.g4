grammar PCF;

// règles syntaxiques

term : LIT                                          # Lit
     | term term                                    # App
     | '(' term ')'                                 # Par
     | term OP1 term                                # BOp
     | term OP2 term                                # BOp
     | 'ifz' term 'then' term 'else' term           # IfZ
     | VAR                                          # Var
     | 'let' assign 'in' term                       # Let
     | 'fun' VAR '->' term                          # Fun
     | 'fixfun' VAR VAR '->' term                   # Fixfun
     ;

assign : VAR '=' term
       | assign 'and' assign
       ;

// règles lexicales
OP1 : '*' | '/';
OP2 : '+' | '-';
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
VAR : [a-zA-Z_]+ [a-zA-Z0-9_]* ;