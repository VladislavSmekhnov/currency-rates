XML = data
MAIN_CLASS = src/main/java/com/currency_tracker/App

clean:
	rm -rf $(XML).xml
	rm -rf $(MAIN_CLASS).class
	rm -rf app.log