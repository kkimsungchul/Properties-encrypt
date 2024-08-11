# Properties-encrypt 프로젝트

### 개발 환경
- windows 10
- Intellij IDEA 2024.02
- JAVA 17

### 사용 라이브러리
- jasypt-spring-boot-starter
  - version: '3.0.5'
  - properties 파일 암호화

- jackson-dataformat-yaml
  - version: '2.17.2'
  - yaml 파일 파싱

- jackson-databind
  - version: '2.17.2'
  - yaml 파일 파싱

- jackson-core
  - version: '2.17.2'
  - yaml 파일 파싱


### 실행
- IDE에서 Main.java 실행
- 또는 Gradle 빌드 후 실행 

### 사용방법
1. resources 폴더에 암호화할 데이터를 .yaml 파일로 작성
2. main클래스에서 filePaht에 생성 경로와 파일명을 맞게 설정
    - resocures 가 기본 경로임
3. Main.java 파일 실행 후 암호화된 데이터 확인
4. 암호화된 데이터를 사용할 프로젝트의 ymal 파일에 붙여넣은 후 사용


### 유의사항
- 매번 암호화된 데이터는 변경됨
- 암호화 key는 별도의 파일로 보관할것
- 실제 프로젝트 적용 시 key값은 환경변수 또는 외부 설정파일로 관리할것
