package parser;

import statements.functions.*;
import statements.functions.file.*;
import statements.functions.list.*;
import statements.functions.logic.*;
import statements.functions.math.*;
import statements.functions.meta.*;
import statements.functions.meta.branch.*;
import statements.functions.meta.functionarity.*;
import statements.functions.meta.lists.*;
import statements.functions.meta.loop.*;
import statements.functions.shuffle.*;
import statements.functions.tests.*;
import statements.functions.time.*;
import statements.keywords.*;

public abstract class builtins {
	public static final Object[][] builtins = {
			{"DEFINE", DEFINE.class},
			{"LIBRA", LIBRA.class},
			{"HIDE", HIDE.class},
			{"IN", IN.class},
			{"==", DefinedAs.class},
			{"maxint", MaxInt.class},
			{"stack", QuoteStack.class},
			//TODO: conts
			//TODO: autoput
			//TODO: undeferror
			//TODO: undefs
			//TODO: echo
			//TODO: clock
			{"time", PushTime.class},
			{"rand", Rand.class},
			{"id", Id.class},
			{"dup", Dup.class},
			{"swap", Swap.class},
			{"rollup", Rollup.class},
			{"rolldown", Rolldown.class},
			{"rotate", Rotate.class},
			{"popd", Popd.class},
			{"dupd", Dupd.class},
			{"rollupd", Rollupd.class},
			{"rolldownd", Rolldownd.class},
			{"rotated", Rotated.class},
			{"pop", Pop.class},
			{"choice", Choice.class},
			{"or", Or.class},
			{"xor", Xor.class},
			{"and", And.class},
			{"not", Not.class},
			{"+", Add.class},
			{"-", Subtract.class},
			{"*", Multiply.class},
			{"/", Divide.class},
			{"rem", Rem.class},
			{"div", Div.class},
			{"sign", Sign.class},
			{"neg", Neg.class},
			{"ord", Ord.class},
			{"chr", Chr.class},
			{"abs", Abs.class},
			{"acos", Acos.class},
			{"asin", Asin.class},
			{"atan", Atan.class},
			{"atan2", Atan2.class},
			{"ceil", Ceil.class},
			{"cos", Cos.class},
			{"cosh", Cosh.class},
			{"exp", Exp.class},
			{"floor", Floor.class},
			{"frexp", Frexp.class},
			{"ldexp", Ldexp.class},
			{"log", Log.class},
			{"log10", Log10.class},
			{"modf", Modf.class},
			{"pow", Pow.class},
			{"sin", Sin.class},
			{"sinh", Sinh.class},
			{"sqrt", Sqrt.class},
			{"tan", Tan.class},
			{"tanh", Tanh.class},
			{"trunc", Trunc.class},
			{"localtime", Localtime.class},
			{"gmtime", Gmtime.class},
			{"mktime", Mktime.class},
			//TODO: Link in Apache Tomcat Catalina to get strftime
			{"strtol", Strtol.class},
			{"strtod", Strtod.class},
			//TODO: format
			//TODO: formatf
			//TODO: srand
			{"pred", Pred.class},
			{"succ", Succ.class},
			{"max", Max.class},
			{"min", Min.class},
			{"fclose", Fclose.class},
			{"feof", Feof.class},
			{"ferror", Ferror.class},
			{"fflush", Fflush.class},
			{"fgetch", Fgetch.class},
			{"fgets", Fgets.class},
			{"fopen", Fopen.class},
			{"fread", Fread.class},
			{"fwrite", Fwrite.class},
			{"fremove", Fremove.class},
			{"frename", Frename.class},
			{"fput", Fput.class},
			{"fputch", Fputch.class},
			{"fputchars", Fputchars.class},
			{"fputstring", Fputchars.class},
			{"fseek", Fseek.class},
			{"ftell", Ftell.class},
			{"unstack", Unstack.class},
			{"cons", Cons.class},
			{"swons", Swons.class},
			{"first", First.class},
			{"rest", Rest.class},
			{"compare", Compare.class},
			{"at", At.class},
			{"of", Of.class},
			{"size", Size.class},
			{"opcase", Opcase.class},
			{"case", Case.class},
			{"uncons", Uncons.class},
			{"unswons", Unswons.class},
			{"drop", Drop.class},
			{"take", Take.class},
			{"concat", Concat.class},
			{"enconcat", Enconcat.class},
			{"name", Name.class},
			{"body", Body.class},
			{"null", Nulltest.class},
			{"small", Small.class},
			{">=", Geq.class},
			{">", Gt.class},
			{"<=", Leq.class},
			{"<", Lt.class},
			{"=", Eq.class},
			{"!=", Neq.class},
			{"equal", Identical.class},
			{"has", Has.class},
			{"integer", TestInt.class},
			{"char", TestChar.class},
			{"logical", TestLogical.class},
			{"string", TestString.class},
			{"set", TestSet.class},
			{"list", TestList.class},
			{"leaf", TestLeaf.class},
			{"user", TestUser.class},
			{"float", TestFloat.class},
			{"file", TestFile.class},
			{"i", I.class},
			{"x", X.class},
			{"dip", Dip.class},
			{"app1", App1.class},
			{"app11", App11.class},
			{"app12", App12.class},
			{"construct", Construct.class},
			{"nullary", Nullary.class},
			{"unary", Unary.class},
			{"unary2", Unary2.class},
			{"unary3", Unary3.class},
			{"unary4", Unary4.class},
			{"app2", Unary2.class},			//Including these anyway
			{"app3", Unary3.class},
			{"app4", Unary4.class},
			{"binary", Binary.class},
			{"ternary", Ternary.class},
			{"cleave", Cleave.class},
			{"branch", Branch.class},
			{"ifte", Ifte.class},
			{"ifinteger", Ifinteger.class},
			{"ifchar", Ifchar.class},
			{"iflogical", Iflogical.class},
			{"ifset", Ifset.class},
			{"ifstring", Ifstring.class},
			{"iflist", Iflist.class},
			{"iffloat", Iffloat.class},
			{"iffile", Iffile.class},
			{"cond", Cond.class},
			{"while", While.class},
			{"linrec", Linrec.class},
			{"tailrec", Tailrec.class},
			{"binrec", Binrec.class},
			{"genrec", Genrec.class},
			{"condlinrec", Condlinrec.class},
			{"step", Step.class},
			{"fold", Fold.class},
			{"map", Map.class},
			{"times", Times.class},
			{"infra", Infra.class},
			{"primrec", Primrec.class},
			{"filter", Filter.class},
			{"split", Split.class},
			{"some", Some.class},
			{"all", All.class},
			{"treestep", Treestep.class},
			{"treerec", Treerec.class},
			{"treegenrec", Treegenrec.class},
			{"gc", Gc.class},
			{"system", SystemCall.class},
			{"put", Put.class},
			{"putch", Putch.class},
			{"putchars", Putchars.class},
			{"abort", Abort.class},
			{"quit", Quit.class}
	};
}
