# 프로젝트 소개
## 개요
- 트렌드 분석 관련 내용 및 목적


## 역할 분담
- 김문수, url 치환코드 작성
- 이소민, 30일 데이터 크롤링 코드 작성
- 정호찬, 7일 데이터 크롤링 코드 작성
- 주예성, 30일 데이터 크롤링 코드 작성
- 주용현, 7일 데이터 크롤링 코드 작성

# 기능 설명
- 설명
- 중요한 코드가 있으면 코드와 함께 설명
- 구현화면에 대한 이미지

## 7일간 데이터 끌어오기
- from datetime import datetime, timedelta
- for i in range(7):
  date = (datetime.now() - timedelta(days=i)).strftime("%Y%m%d")
  url = f"https://news.naver.com/main/list.naver?mode=LPOD&mid=sec&date={date}"
  html = requests.get(url).text
  soup = bs(html, 'html.parser')
