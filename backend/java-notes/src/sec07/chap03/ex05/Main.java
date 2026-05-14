package sec07.chap03.ex05;

public class Main {
    static void main(String[] args) {

        // 아무 유닛이나 태우는 말
        Horse<Unit> avante = new Horse<>(); // ⭐️ Horse<Unit>에서 Unit 생략
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        // 기사 계급 이상을 태우는 말
        Horse<Knight> sonata = new Horse<>();   // Knight 생략
        // sonata.setRider(new Unit());    // ⚠️ 불가
        sonata.setRider(new Knight());
        sonata.setRider( new MagicKnight());

        // 마법기사만 태우는 말
        Horse<MagicKnight> grandeur = new Horse<>();
        // grandeur.setRider(new Unit());   // ⚠️ 불가
        // grandeur.setRider(new Knight());    // ⚠️ 불가
        grandeur.setRider(new MagicKnight());

        // ⚠️ 자료형과 제네릭 타입이 일치하지 않으면 대입 불가
        // - 제네릭 타입이 상속관계에 있어도 마찬가지
        // Horse<Unit> wrongHorse1 = new Horse<Knight>();
        // Horse<Knight> wrongHorse2 = new Horse<Unit>();
        // avante = sonata;
        // sonata = grandeur;

        // ⭐️ 와일드카드 - 제네릭 타입의 다형성을 위함
        // 💡 Knight와 그 자식 클래스만 받을 수 있음
        // 기사 계급 이상을 태우는 말만 대입 받을 수 있는 변수
        Horse<? extends Knight> knightHorse;
        // knightHorse = new Horse<Unit>();    // ⚠️ 불가
        knightHorse = new Horse<Knight>();
        knightHorse = new Horse<MagicKnight>();
        // knightHorse = avante;   // ⚠️ 불가
        knightHorse = sonata;
        knightHorse = grandeur;

        // 💡 Knight과 그 조상 클래스만 받을 수 있음
        // 마법기사만 태우는 말은 받지 않는 변수
        Horse<? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;
        // nonLuxuryHorse = grandeur;  ⚠️ 불가

        // 💡 제한 없음 - <? extends Object> 와 동일
        // 어떤 말이든 받는 변수
        Horse<?> anyHorse;
        anyHorse = avante;
        anyHorse = sonata;
        anyHorse = grandeur;


        HorseShop.intoBestSellers(avante);
        HorseShop.intoBestSellers(sonata);
        HorseShop.intoBestSellers(grandeur);

        // HorseShop.intoPreminums(avante);    ⚠️ 불가
        HorseShop.intoPreminums(sonata);
        HorseShop.intoPreminums(grandeur);

        HorseShop.intoEntryLevels(avante);
        HorseShop.intoEntryLevels(sonata);
        // HorseShop.intoEntryLevels(grandeur);    ⚠️ 불가

        // ⭐️ 제너릭은 변수에 들어올 값에 대한 제한
        // - 데이터 그 자체에 대함이 아님
        Horse[] horses = {avante, sonata, grandeur};
        for (Horse horse : horses) {
            horse.setRider(new Unit());
        }   // ⁉️ 에러 발생하지 않음

        // 에러 발생하지 않는 이유 GPT 설명
        // ⭐️ raw type(로 타입) 사용
        // raw type 사용 시 제네릭 타입 정보가 사라져 컴파일 타임 타입 체크가 불가능해짐 (타입 안전성 깨짐)
        // - Horse[] 는 제네릭 타입 정보(<T>)가 제거된 상태
        // - Horse<Unit>, Horse<Knight>, Horse<MagicKnight> 구분이 사라짐

        // ⭐️ 컴파일 에러가 발생하지 않는 이유
        // - raw type에서는 제네릭 타입이 Object로 처리됨
        // - 즉, setRider(Object rider) 형태로 동작
        // - 따라서 어떤 타입이든 전달 가능 (타입 체크 안 함)

        // ⚠️ 문제점
        // - 제네릭 타입 검사가 사라져 타입 안정성이 깨짐
        // - 예: Horse<MagicKnight>에 Unit이 들어갈 수 있음

        // ⚠️ 이후 값 꺼낼 때 문제 발생 가능
        // - 내부적으로 MagicKnight로 캐스팅 시도
        // - 실제로 Unit이 들어있으면 ClassCastException 발생 (런타임 에러)


        // ✅ 안전한 방법 (와일드카드 사용)
        Horse<?>[] safeHorses = {avante, sonata, grandeur};

        for (Horse<?> horse : safeHorses) {
            // ❌ 컴파일 에러 발생
            // - ? 는 "정확한 타입을 모름" 의미
            // - 따라서 setRider(...) 호출 불가 (타입 안전성 유지)
            // horse.setRider(new Unit());
        }

    }
}
