<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang = "en">

<head>

<link rel="shortcut icon" href="https://algs4.cs.princeton.edu/favicon.ico">
<link rel="stylesheet"    href="https://algs4.cs.princeton.edu/java.css" type="text/css">

<title>EvaluateDeluxe.java</title>

<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<meta NAME="AUTHOR" CONTENT="Robert Sedgewick and Kevin Wayne">
<meta NAME="DESCRIPTION" CONTENT="EvaluateDeluxe code in Java">
<meta NAME="TITLE" CONTENT="EvaluateDeluxe code in Java">
<meta NAME="KEYWORDS" CONTENT="EvaluateDeluxe,java,programming,computer science,algorithm,data structure,program,code">
<meta NAME="ROBOTS" CONTENT="INDEX,FOLLOW">

</head>


<body>
<center><h1>EvaluateDeluxe.java</h1></center><p><br>

Below is the syntax highlighted version of <a href = "EvaluateDeluxe.java">EvaluateDeluxe.java</a>
from <a href = "https://algs4.cs.princeton.edu/13stacks">&#167;1.3 Stacks and Queues</a>.
<p><br>

<!-- Generator: GNU source-highlight 3.1.6
by Lorenzo Bettini
http://www.lorenzobettini.it
http://www.gnu.org/software/src-highlite -->
<pre><tt><span class="comment">/******************************************************************************</span>
<span class="comment"> *  Compilation:  javac EvaluateDeluxe.java</span>
<span class="comment"> *  Execution:    java EvaluateDeluxe</span>
<span class="comment"> *  Dependencies: Stack.java</span>
<span class="comment"> *</span>
<span class="comment"> *  Evaluates arithmetic expressions using Dijkstra's two-stack algorithm.</span>
<span class="comment"> *  Handles the following binary operators: +, -, *, / and parentheses.</span>
<span class="comment"> *</span>
<span class="comment"> *  % echo "3 + 5 * 6 - 7 * ( 8 + 5 )" | java EvaluateDeluxe</span>
<span class="comment"> *  -58.0</span>
<span class="comment"> *</span>
<span class="comment"> *</span>
<span class="comment"> *  Limitiations</span>
<span class="comment"> *  --------------</span>
<span class="comment"> *    -  can easily add additional operators and precedence orders, but they</span>
<span class="comment"> *       must be left associative (exponentiation is right associative)</span>
<span class="comment"> *    -  assumes whitespace between operators (including parentheses)</span>
<span class="comment"> *</span>
<span class="comment"> *  Remarks</span>
<span class="comment"> *  --------------</span>
<span class="comment"> *    -  can eliminate second phase if we enclose input expression</span>
<span class="comment"> *       in parentheses (and, then, could also remove the test</span>
<span class="comment"> *       for whether the operator stack is empty in the inner while loop)</span>
<span class="comment"> *    -  see </span><span class="url">http://introcs.cs.princeton.edu/java/11precedence/</span><span class="comment"> for</span>
<span class="comment"> *       operator precedence in Java</span>
<span class="comment"> *</span>
<span class="comment"> ******************************************************************************/</span>

<span class="preproc">import</span><span class="normal"> java</span><span class="symbol">.</span><span class="normal">util</span><span class="symbol">.</span><span class="normal">TreeMap</span><span class="symbol">;</span>

<span class="keyword">public</span><span class="normal"> </span><span class="keyword">class</span><span class="normal"> </span><span class="classname">EvaluateDeluxe</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">    </span><span class="comment">// result of applying binary operator op to two operands val1 and val2</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">eval</span><span class="symbol">(</span><span class="usertype">String</span><span class="normal"> op</span><span class="symbol">,</span><span class="normal"> </span><span class="type">double</span><span class="normal"> val1</span><span class="symbol">,</span><span class="normal"> </span><span class="type">double</span><span class="normal"> val2</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"+"</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> val1 </span><span class="symbol">+</span><span class="normal"> val2</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"-"</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> val1 </span><span class="symbol">-</span><span class="normal"> val2</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"/"</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> val1 </span><span class="symbol">/</span><span class="normal"> val2</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"*"</span><span class="symbol">))</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> val1 </span><span class="symbol">*</span><span class="normal"> val2</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">throw</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">RuntimeException</span><span class="symbol">(</span><span class="string">"Invalid operator"</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">main</span><span class="symbol">(</span><span class="normal">String</span><span class="symbol">[]</span><span class="normal"> args</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">        </span><span class="comment">// precedence order of operators</span>
<span class="normal">        </span><span class="usertype">TreeMap&lt;String, Integer&gt;</span><span class="normal"> precedence </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> TreeMap</span><span class="symbol">&lt;</span><span class="normal">String</span><span class="symbol">,</span><span class="normal"> Integer</span><span class="symbol">&gt;();</span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">"("</span><span class="symbol">,</span><span class="normal"> </span><span class="number">0</span><span class="symbol">);</span><span class="normal">   </span><span class="comment">// for convenience with algorithm</span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">")"</span><span class="symbol">,</span><span class="normal"> </span><span class="number">0</span><span class="symbol">);</span><span class="normal">  </span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">"+"</span><span class="symbol">,</span><span class="normal"> </span><span class="number">1</span><span class="symbol">);</span><span class="normal">   </span><span class="comment">// + and - have lower precedence than * and /</span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">"-"</span><span class="symbol">,</span><span class="normal"> </span><span class="number">1</span><span class="symbol">);</span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">"*"</span><span class="symbol">,</span><span class="normal"> </span><span class="number">2</span><span class="symbol">);</span>
<span class="normal">        precedence</span><span class="symbol">.</span><span class="function">put</span><span class="symbol">(</span><span class="string">"/"</span><span class="symbol">,</span><span class="normal"> </span><span class="number">2</span><span class="symbol">);</span>

<span class="normal">        </span><span class="usertype">Stack&lt;String&gt;</span><span class="normal"> ops  </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Stack</span><span class="symbol">&lt;</span><span class="normal">String</span><span class="symbol">&gt;();</span>
<span class="normal">        </span><span class="usertype">Stack&lt;Double&gt;</span><span class="normal"> vals </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Stack</span><span class="symbol">&lt;</span><span class="normal">Double</span><span class="symbol">&gt;();</span>

<span class="normal">        </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(!</span><span class="normal">StdIn</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">())</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">            </span><span class="comment">// read in next token (operator or value)</span>
<span class="normal">            </span><span class="usertype">String</span><span class="normal"> s </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readString</span><span class="symbol">();</span>

<span class="normal">            </span><span class="comment">// token is a value</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(!</span><span class="normal">precedence</span><span class="symbol">.</span><span class="function">containsKey</span><span class="symbol">(</span><span class="normal">s</span><span class="symbol">))</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                vals</span><span class="symbol">.</span><span class="function">push</span><span class="symbol">(</span><span class="normal">Double</span><span class="symbol">.</span><span class="function">parseDouble</span><span class="symbol">(</span><span class="normal">s</span><span class="symbol">));</span>
<span class="normal">                </span><span class="keyword">continue</span><span class="symbol">;</span>
<span class="normal">            </span><span class="cbracket">}</span>

<span class="normal">            </span><span class="comment">// token is an operator</span>
<span class="normal">            </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(</span><span class="keyword">true</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">                </span><span class="comment">// the last condition ensures that the operator with higher precedence is evaluated first</span>
<span class="normal">                </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">ops</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">||</span><span class="normal"> s</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"("</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">||</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">precedence</span><span class="symbol">.</span><span class="function">get</span><span class="symbol">(</span><span class="normal">s</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">&gt;</span><span class="normal"> precedence</span><span class="symbol">.</span><span class="function">get</span><span class="symbol">(</span><span class="normal">ops</span><span class="symbol">.</span><span class="function">peek</span><span class="symbol">())))</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                    ops</span><span class="symbol">.</span><span class="function">push</span><span class="symbol">(</span><span class="normal">s</span><span class="symbol">);</span>
<span class="normal">                    </span><span class="keyword">break</span><span class="symbol">;</span>
<span class="normal">                </span><span class="cbracket">}</span>

<span class="normal">                </span><span class="comment">// evaluate expression</span>
<span class="normal">                </span><span class="usertype">String</span><span class="normal"> op </span><span class="symbol">=</span><span class="normal"> ops</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>

<span class="normal">                </span><span class="comment">// but ignore left parentheses</span>
<span class="normal">                </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">"("</span><span class="symbol">))</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                    </span><span class="keyword">assert</span><span class="normal"> s</span><span class="symbol">.</span><span class="function">equals</span><span class="symbol">(</span><span class="string">")"</span><span class="symbol">);</span>
<span class="normal">                    </span><span class="keyword">break</span><span class="symbol">;</span>
<span class="normal">                </span><span class="cbracket">}</span>

<span class="normal">                </span><span class="comment">// evaluate operator and two operands and push result onto value stack</span>
<span class="normal">                </span><span class="keyword">else</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                    </span><span class="type">double</span><span class="normal"> val2 </span><span class="symbol">=</span><span class="normal"> vals</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>
<span class="normal">                    </span><span class="type">double</span><span class="normal"> val1 </span><span class="symbol">=</span><span class="normal"> vals</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>
<span class="normal">                    vals</span><span class="symbol">.</span><span class="function">push</span><span class="symbol">(</span><span class="function">eval</span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">,</span><span class="normal"> val1</span><span class="symbol">,</span><span class="normal"> val2</span><span class="symbol">));</span>
<span class="normal">                </span><span class="cbracket">}</span>
<span class="normal">            </span><span class="cbracket">}</span>
<span class="normal">        </span><span class="cbracket">}</span>

<span class="normal">        </span><span class="comment">// finished parsing string - evaluate operator and operands remaining on two stacks</span>
<span class="normal">        </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(!</span><span class="normal">ops</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">())</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="usertype">String</span><span class="normal"> op </span><span class="symbol">=</span><span class="normal"> ops</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>
<span class="normal">            </span><span class="type">double</span><span class="normal"> val2 </span><span class="symbol">=</span><span class="normal"> vals</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>
<span class="normal">            </span><span class="type">double</span><span class="normal"> val1 </span><span class="symbol">=</span><span class="normal"> vals</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">();</span>
<span class="normal">            vals</span><span class="symbol">.</span><span class="function">push</span><span class="symbol">(</span><span class="function">eval</span><span class="symbol">(</span><span class="normal">op</span><span class="symbol">,</span><span class="normal"> val1</span><span class="symbol">,</span><span class="normal"> val2</span><span class="symbol">));</span>
<span class="normal">        </span><span class="cbracket">}</span>

<span class="normal">        </span><span class="comment">// last value on stack is value of expression</span>
<span class="normal">        StdOut</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="normal">vals</span><span class="symbol">.</span><span class="function">pop</span><span class="symbol">());</span>
<span class="normal">        </span><span class="keyword">assert</span><span class="normal"> vals</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">();</span>
<span class="normal">        </span><span class="keyword">assert</span><span class="normal"> ops</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">();</span>
<span class="normal">    </span><span class="cbracket">}</span>
<span class="cbracket">}</span>
</tt></pre>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-10811519-2");
pageTracker._trackPageview();
} catch(err) {}</script>

</body>

<p><br><address><small>
Copyright &copy; 2000&ndash;2017, Robert Sedgewick and Kevin Wayne.
<br>Last updated: Fri Oct 20 12:50:46 EDT 2017.
</small></address>

</html>
