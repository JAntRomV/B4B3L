const path = require('path');

// Centraliza las rutas del proyecto para que los tests no tengan paths relativos frágiles
module.exports = {
    JS_OUTPUT_DIR: path.join(__dirname, '../test_data/ChatGPT/v1/Transcribed_JS'),
    ORIGINAL_JAVA_DIR: path.join(__dirname, '../test_data/ChatGPT/v1/Original')
};