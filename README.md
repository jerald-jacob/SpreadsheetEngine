# SpreadsheetEngine
A repository containing a Java implementation of a spreadsheet engine with support for updating and retrieving cell values.

Design a spreadsheet backend which can support two operations:
<br>
void setCellValue(String cellId, Object value)<br>
int getCellValue(String cellId)<br>
<br>

## Example:<br>
setCellValue(&quot;A1&quot;, 13)<br>
setCellValue(&quot;A2&quot;, 14)<br><br>
getCellValue(&quot;A1&quot;) -&gt; 13<br><br>
setCellValue(&quot;A3&quot;, &quot;=A1+A2&quot;)<br>
getCellValue(&quot;A3&quot;) -&gt; 27<br><br>
setCellValue(&quot;A4&quot;, &quot;=A1+A2+A3&quot;)<br>
getCellValue(&quot;A3&quot;) -&gt; 54<br>
