# fennec

> Use fennec for easy git

## 개요
대구소프트웨어고등학교 입학전형시스템 개발동아리, CNS에서 개발한 Git 간편화 도구입니다.

## 기능
### 브랜치 생성
> Gitflow 전략에 맞는 브랜치를 생성합니다

```shell
fennec branch new
# or..
fennec branch new <종류> <이슈번호> <제목>
```

### Type & Finish
> 명령어 한번으로 git add, commit, push까지 수행합니다

## 설치
### Linux & MacOS
 1. `install.sh`에 실행권한을 부여해 주세요
```shell
chmod 777 install.sh
```

 2. `install.sh`를 관리자 권한으로 실행하세요
```shell
./install.sh
```

 3. 설치가 끝났습니다, fennec 명령어를 실행해보세요!
```shell
> fennec

fennec upload <메시지 타입(CREATE/FEATURE/BUG/DELETE/REFACTOR/SETUP/DOCS/TEST)> <메시지 제목> <메시지 바디?>
  * git commit 및 push를 진행합니다
  * Required args:
    * '메시지 타입(CREATE/FEATURE/BUG/DELETE/REFACTOR/SETUP/DOCS/TEST)'(ENUM_COMMITTYPE)
    * '메시지 제목'(STRING)
    * '메시지 바디'(STRING?)

fennec help 
  * 도움말을 출력합니다
  * Required args:

...
```

### Windows
> 설치 스크립트가 준비중입니다