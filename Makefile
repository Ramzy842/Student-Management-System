# Makefile

# Variables
SRC_DIR = .
OUT_DIR = out
MAIN_CLASS = com.Ramzy842.sms.App

# Find all .java files
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Default target
all: compile run

# Compile Java files
compile:
	javac -d $(OUT_DIR) $(SOURCES)

# Run the main class
run:
	java -cp $(OUT_DIR) $(MAIN_CLASS)

# Clean compiled files
clean:
	rm -rf $(OUT_DIR)
