package move_method.before;

/**
 * 메서드 이동
 * 방법 : 메서드가 자신이 속한 클래스보다 다른 클래스의 기능을 더 많이 사용할 땐, 그 메서드가 제일 많이 이용하는 클래스 안에서 비슷한 내용의 새 메서드를 작성한다.
 * 기존 메서드는 간단한 대리 메서드로 전환하든지 아예 삭제하자.
 *
 * use case : 클래스에 기능이 너무 많거나 클래스가 다른 클래스와 과하게 연동되어 의존성이 지나칠 때는 메서드를 옮기는 것이 좋다.
 */
public class Account {
    private AccountType _type;
    private int _daysOverdrawn;

    double overdraftCharge() {
        if (_type.isPremium()) {
            double result = 10;

            if (_daysOverdrawn > 7) {
                result += (_daysOverdrawn - 7) * 0.85;
            }

            return result;
        } else {
            return _daysOverdrawn * 1.75;
        }
    }

    double bankCharge() {
        double result = 4.5;

        if (_daysOverdrawn > 0) {
            result += overdraftCharge();
        }

        return result;
    }
}
