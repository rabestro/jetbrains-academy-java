package editor.service;

import editor.component.TextPane;

import java.util.Collections;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.Logger.Level.TRACE;

public class SearchService {
    private static final System.Logger LOGGER = System.getLogger("");

    private final TextPane textArea;
    private List<MatchResult> matches;
    private int index;

    public SearchService(final TextPane textArea) {
        this.textArea = textArea;
        reset();
    }

    public void reset() {
        matches = Collections.emptyList();
    }

    public void startSearch(final Pattern pattern) {
        LOGGER.log(TRACE, "Start search: {0}", pattern);
        final var matcher = pattern.matcher(textArea.getText());
        matches = matcher.results().collect(Collectors.toUnmodifiableList());
        index = -1;
        next();
        LOGGER.log(TRACE, "Exit search. Found: {0}", matches.size());
    }

    public void next() {
        selectText(i -> (i + 1) % matches.size());
    }

    public void previous() {
        selectText(i -> (i + matches.size() - 1) % matches.size());
    }

    private void selectText(final IntUnaryOperator operator) {
        if (matches.isEmpty()) {
            return;
        }
        index = operator.applyAsInt(index);
        final var result = matches.get(index);
        textArea.highlightMatch(result.start(), result.end());
    }

}
