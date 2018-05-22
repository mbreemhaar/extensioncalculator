package Parser;

import Model.PropositionalLogic.*;
import org.antlr.v4.runtime.*;

public class FParser {
    public static Formula parse(String input) {
        ANTLRInputStream chars = new ANTLRInputStream(input);
        FormulaLexer lexer = new FormulaLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormulaParser parser = new FormulaParser(tokens);

        FormulaParser.FormulaContext formulaContext = parser.formula();

        FVisitor visitor = new FVisitor();

        return visitor.visit(formulaContext);
    }
}