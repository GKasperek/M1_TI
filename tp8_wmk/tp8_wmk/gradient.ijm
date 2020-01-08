
run("32-bit");
run("Convolve...", "text1=[-0.125 -0.25 -0.125\n0 0 0\n0.125 0.25 0.125\n] normalize");
selectWindow("dx.pgm");
run("32-bit");
run("Convolve...", "text1=[-0.125 0 0.125\n -0.25 0 0.25\n-0.125 0 0.125\n] normalize");
run("Square");
selectWindow("dy.pgm");
run("Square");
imageCalculator("Add create 32-bit", "dx.pgm","dy.pgm");
selectWindow("Result of dx.pgm");
run("Square Root");
run("Max...", "value=255");
