JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
Server.java\
Processor.java\
Event.java\

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) */*.class

server:
	$(JAVA) Server