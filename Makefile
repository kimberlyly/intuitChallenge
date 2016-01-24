JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Sort.java \
	PrimeSieve.java \
	JsonPath.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class