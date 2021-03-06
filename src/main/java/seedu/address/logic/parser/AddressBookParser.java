package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.commands.AddEventTagCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteEventCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditEventAddressCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FavouriteCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FindEventCommand;
import seedu.address.logic.commands.GenerateLocationCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ImportContactsCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListEventCommand;
import seedu.address.logic.commands.NotificationCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.SeeEventContactsCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.ShowLocationCommand;
import seedu.address.logic.commands.ToggleCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
        case AddCommand.COMMAND_WORD_ALIAS: // test case for command alias
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
        case EditCommand.COMMAND_WORD_ALIAS:
            return new EditCommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
        case SelectCommand.COMMAND_WORD_ALIAS:
            return new SelectCommandParser().parse(arguments);

        case ShowLocationCommand.COMMAND_WORD:
        case ShowLocationCommand.COMMAND_WORD_ALIAS:
            return new ShowLocationCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
        case DeleteCommand.COMMAND_WORD_ALIAS:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
        case ClearCommand.COMMAND_WORD_ALIAS:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
        case FindCommand.COMMAND_WORD_ALIAS:
            return new FindCommandParser().parse(arguments);

        case FindEventCommand.COMMAND_WORD:
        case FindEventCommand.COMMAND_WORD_ALIAS:
            return new FindEventCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
        case ListCommand.COMMAND_WORD_ALIAS:
            return new ListCommand();

        case AddEventCommand.COMMAND_WORD:
        case AddEventCommand.COMMAND_WORD_ALIAS:
            return new AddEventCommandParser().parse(arguments);

        case SeeEventContactsCommand.COMMAND_WORD:
        case SeeEventContactsCommand.COMMAND_WORD_ALIAS:
            return new SeeEventContactsCommandParser().parse(arguments);

        case EditEventAddressCommand.COMMAND_WORD:
        case EditEventAddressCommand.COMMAND_WORD_ALIAS:
            return new EditEventAddressCommandParser().parse(arguments);

        case DeleteEventCommand.COMMAND_WORD:
        case DeleteEventCommand.COMMAND_WORD_ALIAS:
            return new DeleteEventCommandParser().parse(arguments);

        case AddEventTagCommand.COMMAND_WORD:
        case AddEventTagCommand.COMMAND_WORD_ALIAS:
            return new AddEventTagCommandParser().parse(arguments);

        case HistoryCommand.COMMAND_WORD:
        case HistoryCommand.COMMAND_WORD_ALIAS:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
        case ExitCommand.COMMAND_WORD_ALIAS:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
        case HelpCommand.COMMAND_WORD_ALIAS:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
        case UndoCommand.COMMAND_WORD_ALIAS:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
        case RedoCommand.COMMAND_WORD_ALIAS:
            return new RedoCommand();

        case ImportContactsCommand.COMMAND_WORD:
        case ImportContactsCommand.COMMAND_WORD_ALIAS:
            return new ImportContactsCommandParser().parse(arguments);

        case NotificationCommand.COMMAND_WORD:
        case NotificationCommand.COMMAND_WORD_ALIAS:
            return new NotificationCommandParser().parse(arguments);

        case FavouriteCommand.COMMAND_WORD:
        case FavouriteCommand.COMMAND_WORD_ALIAS:
            return new FavouriteCommandParser().parse(arguments);

        case ListEventCommand.COMMAND_WORD:
        case ListEventCommand.COMMAND_WORD_ALIAS:
            return new ListEventCommand();

        case GenerateLocationCommand.COMMAND_WORD:
        case GenerateLocationCommand.COMMAND_WORD_ALIAS:
            return new GenerateLocationCommandParser().parse(arguments);

        case ToggleCommand.COMMAND_WORD:
        case ToggleCommand.COMMAND_WORD_ALIAS:
            return new ToggleCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
