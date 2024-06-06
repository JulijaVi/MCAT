document.getElementById('analysisForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Get the text content from the textarea
    var textContent = document.getElementById('textContent').value;

    // Initialize the score
    var score = 0;

    // Criteria checks
    var youthRepresentation = /youth|young person|under 35 years of age/.test(textContent);
    var inclusionOfMinorityVoices = /minority groups|traditionally excluded sectors/.test(textContent);
    var contentFormat = /Reels|TikToks|short form articles|social media posts|audiovisual content/.test(textContent);
    var topicRelevance = /Environment|social issues|human rights|inclusivity|health|reproductive rights|local politics/.test(textContent);
    var subjectMatterBias = !/biased|partial/.test(textContent);
    var topicFocus = /women’s issues|rights|LGBTQ+ rights|rights of people with disabilities|ethnic|racial minority rights/.test(textContent);
    var genderBiasLanguage = /feminitives/.test(textContent);
    var masculinePronouns = !/he|him|his/.test(textContent) || /they|them|their/.test(textContent);
    var collectiveNouns = /people|persons|individuals/.test(textContent);

    // Calculate the score
    score += youthRepresentation ? 1 : 0;
    score += inclusionOfMinorityVoices ? 1 : 0;
    score += contentFormat ? 1 : 0;
    score += topicRelevance ? 1 : 0;
    score += subjectMatterBias ? 1 : 0;
    score += topicFocus ? 1 : 0;
    score += genderBiasLanguage ? 1 : 0;
    score += masculinePronouns ? 1 : 0;
    score += collectiveNouns ? 1 : 0;

    // Output the score
    alert('The total score for inclusivity and representation is: ' + score);
});
