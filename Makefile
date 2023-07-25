APP_DIR = app

XML = $(APP_DIR)/data
MAIN_CLASS = $(APP_DIR)/src/main/java/com/currency_tracker/App


all: clean run

run:
	bash run.sh

clean:
	rm -rf $(APP_DIR)/$(XML).xml
	rm -rf $(APP_DIR)/$(MAIN_CLASS).class
	rm -rf $(APP_DIR)/app.log
	docker rmi -f currency_rates