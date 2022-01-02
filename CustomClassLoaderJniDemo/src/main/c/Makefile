CC = g++
JAVA_HOME:=`/usr/libexec/java_home`
CPPFLAGS:=-I $(JAVA_HOME)/include -I $(JAVA_HOME)/include/darwin

ifeq ($(shell uname), Darwin)
  LIBLINK    = -dynamiclib
  TARGET     = libdecrypt.dylib
  INCLUDEDIR := -I $(JAVA_HOME)/include/ -I $(JAVA_HOME)/include/darwin/
endif

ifeq ($(shell uname), Linux)
  LIBLINK    = -shared -fPIC
  TARGET     = libdecrypt.so
  INCLUDEDIR := -I $(JAVA_HOME)/include/ -I $(JAVA_HOME)/include/linux/
endif

all:
	$(CC) $(LIBLINK)  $(INCLUDEDIR) decrypt.cpp -o $(TARGET)

clean:
	rm $(TARGET)

