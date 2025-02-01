import spacy
from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

nlp = spacy.load("en_core_web_sm")

@app.route('/tag', methods=['POST'])
def generate_tags():
    data = request.json
    text = data.get("text", "")
    doc = nlp(text)
    tags = [token.lemma_ for token in doc if token.is_alpha and not token.is_stop]
    return jsonify({"tags": list(set(tags))})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)