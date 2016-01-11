package parser;

import statements.functions.Choice;
import statements.functions.Chr;
import statements.functions.Id;
import statements.functions.Ord;
import statements.functions.Strtod;
import statements.functions.Strtol;
import statements.functions.Times;
import statements.functions.list.At;
import statements.functions.list.Cons;
import statements.functions.list.First;
import statements.functions.list.Of;
import statements.functions.list.QuoteStack;
import statements.functions.list.Rest;
import statements.functions.list.Size;
import statements.functions.list.Swons;
import statements.functions.list.Uncons;
import statements.functions.list.Unstack;
import statements.functions.list.Unswons;
import statements.functions.logic.And;
import statements.functions.logic.Not;
import statements.functions.logic.Or;
import statements.functions.logic.Xor;
import statements.functions.math.Abs;
import statements.functions.math.Acos;
import statements.functions.math.Add;
import statements.functions.math.Asin;
import statements.functions.math.Atan;
import statements.functions.math.Atan2;
import statements.functions.math.Ceil;
import statements.functions.math.Cos;
import statements.functions.math.Cosh;
import statements.functions.math.Div;
import statements.functions.math.Divide;
import statements.functions.math.Exp;
import statements.functions.math.Floor;
import statements.functions.math.Frexp;
import statements.functions.math.Ldexp;
import statements.functions.math.Log;
import statements.functions.math.Log10;
import statements.functions.math.Max;
import statements.functions.math.MaxInt;
import statements.functions.math.Min;
import statements.functions.math.Modf;
import statements.functions.math.Multiply;
import statements.functions.math.Neg;
import statements.functions.math.Pow;
import statements.functions.math.Pred;
import statements.functions.math.Rand;
import statements.functions.math.Rem;
import statements.functions.math.Sign;
import statements.functions.math.Sin;
import statements.functions.math.Sinh;
import statements.functions.math.Sqrt;
import statements.functions.math.Subtract;
import statements.functions.math.Succ;
import statements.functions.math.Tan;
import statements.functions.math.Tanh;
import statements.functions.math.Trunc;
import statements.functions.meta.Case;
import statements.functions.meta.Dip;
import statements.functions.meta.I;
import statements.functions.meta.Nullary;
import statements.functions.meta.Unary;
import statements.functions.shuffle.Dup;
import statements.functions.shuffle.Dupd;
import statements.functions.shuffle.Pop;
import statements.functions.shuffle.Popd;
import statements.functions.shuffle.Rolldown;
import statements.functions.shuffle.Rolldownd;
import statements.functions.shuffle.Rollup;
import statements.functions.shuffle.Rollupd;
import statements.functions.shuffle.Rotate;
import statements.functions.shuffle.Rotated;
import statements.functions.shuffle.Swap;
import statements.functions.time.Gmtime;
import statements.functions.time.Localtime;
import statements.functions.time.Mktime;
import statements.functions.time.PushTime;
import statements.keywords.DEFINE;
import statements.keywords.DefinedAs;

public abstract class builtins {
	public static final Object[][] builtins = {
			{"DEFINE", DEFINE.class},
			{"==", DefinedAs.class},
			{"maxint", MaxInt.class},
			//TODO: setsize
			{"stack", QuoteStack.class},
			//TODO: conts
			//TODO: autoput
			//TODO: undeferror
			//TODO: undefs
			//TODO: echo
			//TODO: clock
			{"time", PushTime.class},
			{"rand", Rand.class},
			//TODO: stdin
			//TODO: stdout
			//TODO: stderr
			{"id", Id.class},
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
			//TODO: fclose
			//TODO: feof
			//TODO: ferror
			//TODO: fflush
			//TODO: fgetch
			//TODO: fgets
			//TODO: fopen
			//TODO: fread
			//TODO: fwrite
			//TODO: fremove
			//TODO: frename
			//TODO: fput
			//TODO: fputch
			//TODO: fputchars
			//TODO: fputstring
			//TODO: fputstring
			//TODO: fseek
			//TODO: ftell
			{"unstack", Unstack.class},
			{"cons", Cons.class},
			{"swons", Swons.class},
			{"first", First.class},
			{"rest", Rest.class},
			//TODO: compare
			{"at", At.class},
			{"of", Of.class},
			{"size", Size.class},
			//TODO: opcase
			{"case", Case.class},
			{"uncons", Uncons.class},
			{"unswons", Unswons.class},
			{"times", Times.class},
			{"dip", Dip.class},
			{"i", I.class},
			{"nullary", Nullary.class},
			{"dup", Dup.class},
			{"unary", Unary.class}
	};
}