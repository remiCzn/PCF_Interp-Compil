grammar PCF;

// règles syntaxiques

term : LIT                                   # Lit
     | '(' OP term term ')'                  # BOp
     | '(' 'ifz' term term term ')'          # IfZ
     | VAR                                   # Var
     | '(' 'let' VAR term term ')'           # Let
     | term term                             # App
     | '(' 'fun' VAR term ')'                # Fun
     | '(' 'fix' VAR term ')'                # Fix
     ;

// règles lexicales

OP  : '+' | '-' | '*' | '/' ;
LIT : '0' | [1-9][0-9]* ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
VAR : [a-zA-Z_]+ [a-zA-Z0-9_]* ;