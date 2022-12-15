package org.example;

// Секция "Вопросы о важном" xpath(".//div[@class = 'Home_FourPart__1uthg']")
// Элемент списка вопросов xpath(".//div[@class = 'accordion__item']")
// Кнопка для раскрытия аккордеона id = accordion__heading-0 max -7, class = accordion__button, status: aria-expanded = true/false
// Div с текстом после раскрытия аккордеона class = accordion__panel, id = accordion__panel-0 max -7
// p текст после раскрытия аккордеона
//2
// Кнопка "Заказать" -1  class = Button_Button__ra12g
// Кнопка "Заказать" -2 class = Button_Button__ra12g Button_UltraBig__UU3Lp

//Order page
// First Name xpath (.//input[@placeholder = '* Имя'])
// Last Name xpath (.//input[@placeholder = '* Фамилия'])
// Address xpath (.//input[@placeholder = '* Адрес: куда привезти заказ'])
// Metro xpath (.//input[@class = 'select-search__input'])
//metro ddl select-search__select
// Phone xpath (.//input[@placeholder = '* Телефон: на него позвонит курьер'])
// Кнопка "Далее" (xpath (.//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']))

// Про аренду class = Order_Header__BZXOb text()='Про аренду'
// Когда привезти .//input[@placeholder = '* Когда привезти самокат'], проверить value после ввода
// Календарь  div class = react-datepicker
//Дата в календаре div class = react-datepicker__day react-datepicker__day--001 react-datepicker__day--keyboard-selected react-datepicker__day--today
// aria-label = Choose четверг, 1-е декабря 2022 г.
//Срок аренды  div class = Dropdown-placeholder
// ddl div class = Dropdown-menu ждать пока aria-expanded = "true"
// ddl item  div class=Dropdown-option text()= сутки, двое суток, трое, четверо, пятеро, шестеро, семеро
// Цвет самоката
//черный жемчуг input id=black class=Checkbox_Input__14A2w
//серая безысходность input id=grey class=Checkbox_Input__14A2w
// Комментарий для курьера  input @placeholder =Комментарий для курьера
//Кнопка "Назад" button class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i
// Кнопка "Заказать" button class=Button_Button__ra12g Button_Middle__1CSJM

// confirm class=Order_Modal__YZ-d3
//Title
//yes .//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() = 'Нет']
// no .//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']

//order completed  class=Order_Modal__YZ-d3
//заголовок div class= Order_ModalHeader__3FDaJ #text
// посмотреть статус .//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_NextButton__1_rCA']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']


