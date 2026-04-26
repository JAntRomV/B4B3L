# DEVELOP Branch

## Environment configuration

### 1. Install python 3.12.9 version
```
pyenv install 3.12.9
```

### 2. #Install pyenv-virtualenv if it is not installed
```
brew install pyenv-virtualenv
```

### 3. Create and activate environment
```
pyenv virtualenv 3.12.9 agentic-ai

pyenv activate agentic-ai
```

### 4. Install requirements.txt
```
pip install -r requirements.txt
```

## How to use

# Translate to Python
```
python main.py -i Calculator.java -t python -o result.py
```

# Translate to JavaScript
```
python main.py -i Calculator.java -t javascript -o result.js
```

# See direct result in console
```
python main.py -i Calculator.java -t python

python main.py -i Calculator.java -t javascript
```