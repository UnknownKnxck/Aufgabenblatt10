package b;

import java.util.ArrayList;

class PasswordChecker {
    private ArrayList<PasswordRequirement> requirements = new ArrayList<PasswordRequirement>();

    void add(PasswordRequirement requirement) {
        requirements.add(requirement);
    }

    void check(String password) throws Exception {
        for (PasswordRequirement requirement : requirements) {
            requirement.check(password);
        }
    }
}

class PasswordNotLongEnoughException extends Exception {
    PasswordNotLongEnoughException(String message) {
        super(message);
    }
}

class PasswordNotStrongEnoughException extends Exception {
    PasswordNotStrongEnoughException(String message) {
        super(message);
    }
}

class MinimumLengthRequirement implements PasswordRequirement {
    private int minimumLength;

    MinimumLengthRequirement(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    @Override
    public void check(String password) throws PasswordNotLongEnoughException {
        if (password.length() <= minimumLength) {
            throw new PasswordNotLongEnoughException("Password is not long enough");
        }
    }
}

class MaximumLengthRequirement implements PasswordRequirement {
    private int maximumLength;

    MaximumLengthRequirement(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    @Override
    public void check(String password) throws PasswordNotLongEnoughException {
        if (password.length() >= maximumLength) {
            throw new PasswordNotLongEnoughException("Password is too long");
        }
    }
}

class RequireLowercaseCharacter implements PasswordRequirement {
    @Override
    public void check(String password) throws PasswordNotStrongEnoughException {
        boolean lowercaseFound = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseFound = true;
                break;
            }
        }
        if (!lowercaseFound) {
            throw new PasswordNotStrongEnoughException("Password does not contain a lowercase character");
        }
    }
}

class RequireUppercaseCharacter implements PasswordRequirement {
    @Override
    public void check(String password) throws PasswordNotStrongEnoughException {
        boolean uppercaseFound = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseFound = true;
                break;
            }
        }
        if (!uppercaseFound) {
            throw new PasswordNotStrongEnoughException("Password does not contain an uppercase character");
        }
    }
}

class RequireSpecialCharacter implements PasswordRequirement {
    @Override
    public void check(String password) throws PasswordNotStrongEnoughException {
        boolean specialCharacterFound = false;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialCharacterFound = true;
                break;
            }
        }
        if (!specialCharacterFound) {
            throw new PasswordNotStrongEnoughException("Password does not contain a special character");
        }
    }
}

class RequireNumber implements PasswordRequirement {
    @Override
    public void check(String password) throws PasswordNotStrongEnoughException {
        boolean numberFound = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                numberFound = true;
                break;
            }
        }
        if (!numberFound) {
            throw new PasswordNotStrongEnoughException("Password does not contain a number");
        }
    }
}