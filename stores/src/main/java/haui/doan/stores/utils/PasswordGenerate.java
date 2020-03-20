package haui.doan.stores.utils;


import org.passay.CharacterRule;
import org.passay.PasswordGenerator;

import java.util.Arrays;
import java.util.List;

import static org.passay.EnglishCharacterData.Digit;
import static org.passay.EnglishCharacterData.LowerCase;
import static org.passay.EnglishCharacterData.UpperCase;

/**
 * The utils generate password random with rules is upper case, lower case and digit in password value
 *
 * @author DoanDV
 */
public class PasswordGenerate {

    /**
     * The method is used to generate password for random for
     *
     * @return password to generate for user
     */
    public static String generatePassword() {
        List<CharacterRule> rules = Arrays.asList(
                new CharacterRule(UpperCase, 1),
                new CharacterRule(LowerCase, 1),
                new CharacterRule(Digit, 1));
        PasswordGenerator generator = new PasswordGenerator();
        return generator.generatePassword(8, rules);
    }
}
