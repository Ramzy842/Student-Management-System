SRC_DIR = src
OUT_DIR = out
MAIN_CLASS = App

SOURCES := $(wildcard $(SRC_DIR)/*.java)

all: compile run

compile:
	@mkdir -p $(OUT_DIR)
	@javac -d $(OUT_DIR) $(SOURCES)

run:
	@java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	@rm -rf $(OUT_DIR)

re: clean all