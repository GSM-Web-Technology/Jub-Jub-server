# jup-jup-server
 Gwangju Software Meister High School Equipment Management Project

# PR 규칙
1. Projects에 개발해야 할 것들을 작성하기
2. - gitflow이용시 `feature/{branch-name}` 형식
   - 이슈 추적 이용시 `feature/{issue-number}-{feature-name}` 형식으로 develop에서 branch 만들기
3. 개발해야할 것들에 필요한 파일만 건드리고, develop으로 PR 날리기
4. PR 보고 내가 리뷰 해주면 marge 하기
5. 개발 시작과 동시에 Project에서 자신이 맡은 블럭 In Progress로 옮기고 marge까지 완료가 되면 Done으로 옮기기


# GitFlow
# gitflow 용어 정리

### 주요 브랜치
- 배포 `master` 브랜치
  - 먼저 배포했거나 배포 준비(production-ready)된 코드는 `origin/master`에 두고 관리한다.
  - master 브랜치에 병합한다는 것은 새버전을 배포한다는 것을 의미한다. `master` 브랜치에 커밋될 때 git hook 스크립트를 걸어서 자동으로 빌드하여 운영서버로 배포하는 형식을 취한다.

- 개발 `develop` 브랜치
  - 배포하기 위해 개발하는 코드는 `origin/develop`에서 관리한다. 프로젝트를 진행하는 개발자들이 함께 보며 업무를 진행하는 브랜치이며 가장 역동적인 브랜치라고 할 수 있다.
  - `develop 브랜치 코드가 안정화되고 배포할 준비가 되면 `master`로 병합하고 배포 버전으로 태그를 단다.

### 보조 브랜치
- 기능 `feature` 브랜치
  - 시작 브랜치 : `develop`
  - 병합 대상 브랜치 : `develop`
  - 브랜치 이름 규칙 : `master`, `develop`, `release-`, `hotfix`를 제외한 모든 이름
  - 기능 `feature` 브랜치는 배포하려고 하는 기능을 개발하는 브랜치이다. 기능을 개발하기 시작할 때는 언제 배포할 수 있을지 알 수 없다.
  - 프로젝트를 진행하면서 애자일 방법론을 도입했다면, 스프린트 기간 동안 개발해야할 기능이라면 스프린트 기간 동안 개발해야할 브랜치를 말한다.
  - 기능 `feature` 브랜치는 그 기능을 다 완성할 때까지 유지하고 있다가 다 완성되면 `develop` 브랜치로 병합된다.
    - gitflow이용시 `feature/{branch-name}` 형식
    - 이슈 추적 이용시 `feature/{issue-number}-{feature-name}` 형식
      - EX) `feature/1-init-project`, `feature/2-build-gradle-script-write`

- 출시 `release` 브랜치
  - 시작 브랜치 : `develop`
  - 병합 대상 브랜치 : `develop`, `master`
  - 브랜치 이름 규칙 : `release-*`
  - 출시 `release` 브랜치는 실제 배포할 상태가 된 경우에 생성하는 브랜치이다. `master` 브랜치로 통해 배포하기로 했으므로 먼저 출시 `release` 브랜치를 `master` 브랜치로 병합한다.
  - 나중에 이 배포 버전을 찾기 쉽도록 태그를 만들어 현재 병합되는 커밋을 가리키도록 한다.
  - 이때 배포된 기능에 배포된 기능에 반영할 수 있도록 개발 `develop` 브랜치에도 함께 병합한다.

- 긴급 수정 `hotfix` 브랜치
  - 시작 브랜치 : `master`
  - 병합 대상 브랜치 : `develop`, `master`
  - 브랜치 이름 규칙 : `hotfix-*`
  - 미리 계획되지 않은 배포를 위한 브랜치이다. 기본적인 동작 방식을 출시 `release` 브랜치와 비슷하다.
  - 이미 배포한 운영버전에서 발생한 문제를 해결하기 위해 만든다.
  - 운영 버전에 생긴 치명적인 버그는 즉시 해결해야하기 때문에 문제가 생기면 마스터 `master` 브랜치에 만들어둔 태그 `tag` 로부터 긴급수정 `hotfix` 브랜치를 생성한다.

# PR 취소하기
PR을 날린 레포로 가서 PR부분에서 내가 날린 PR을 클릭 => "close pull requst" 클릭
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FDG9F6%2FbtqBiCvEu2i%2Frhu7wzRMbVZqwjvzJxxdI0%2Fimg.png">
<br/>
# Commit 취소하기
[Commit 취소하기](https://fuirosun.tistory.com/entry/git-git-push-%EB%90%98%EB%8F%8C%EB%A6%AC%EA%B8%B0){: target="_blank"}

