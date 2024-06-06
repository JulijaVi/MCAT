import re
import nltk
nltk.download('punkt')
from nltk.tokenize import word_tokenize

# Get the text content
textContent = """
Paste your article content here
"""

# Initialize the score
score = 0

# Criteria checks
youthRepresentation = bool(re.search(r'youth|young person|under 35 years of age', textContent))
inclusionOfMinorityVoices = bool(re.search(r'minority groups|traditionally excluded sectors', textContent))
contentFormat = bool(re.search(r'Reels|TikToks|short form articles|social media posts|audiovisual content', textContent))
topicRelevance = bool(re.search(r'Environment|social issues|human rights|inclusivity|health|reproductive rights|local politics', textContent))
subjectMatterBias = not bool(re.search(r'biased|partial', textContent))
topicFocus = bool(re.search(r'women’s issues|rights|LGBTQ+ rights|rights of people with disabilities|ethnic|racial minority rights', textContent))
genderBiasLanguage = bool(re.search(r'feminitives', textContent))

# Check for masculine pronouns
words = word_tokenize(textContent)
masculinePronouns = 'he' in words or 'him' in words or 'his' in words
collectiveNouns = 'they' in words or 'them' in words or 'their' in words

# Calculate the score
score += youthRepresentation
score += inclusionOfMinorityVoices
score += contentFormat
score += topicRelevance
score += subjectMatterBias
score += topicFocus
score += genderBiasLanguage
score += not masculinePronouns
score += collectiveNouns

# Output the score
print('The total score for inclusivity and representation is:', score)
