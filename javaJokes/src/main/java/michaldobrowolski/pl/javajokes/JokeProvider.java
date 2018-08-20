package michaldobrowolski.pl.javajokes;

import michaldobrowolski.pl.javajokes.utils.RandomSelector;

public class JokeProvider {

    private static final String[] JOKES = new String[]{
            "Q: What do you call a boomerang that won't come back? A: A stick.",
            "Q: What do you call a clairvoyant midget who just broke out of prison? A: A small medium at large.",
            "Q: What's the best thing about having Alzheimer's Disease? A: You can hide your own easter eggs.",
            "Q: What's the difference between ‘Oooh’ and ‘Aaah’? A: About 3 inches",
            "Q: How do you know if a blonde has been sending e-mail? A: You see a bunch of envelopes stuffed into the disk drive.",
            "Q: Why do most women pay more attention to their appearance than improving their minds? A: Because most men are stupid but few are blind.",
            "Q: What do you call a group of blondes on roller skates? A: A mobile sperm bank.",
            "Q: How do you tell a male chromosome from a female chromosome? A: Pull down its genes.",
            "Q: What do breasts and martinis have in common? A: One is not enough and three are too many.",
            "Q: What do you call a row of rabbits jumping backwards? A: A receding hair line."
    };

    public static String getRandomJoke() {
        return JOKES[RandomSelector.randomInt(JOKES.length - 1)];
    }
}

