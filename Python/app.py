import random
from datetime import datetime, date

# birth_date = input("geburtsdatum: ")
# x = date.today().year - int(birth_date)
#
# print("sie sind " + str(x) + " alt")
# messege = "hallo {} bitte geben sie ihren alt ein"
# name = input("Bitte geben sie ihren Name ein ")
#
# age = int(input(messege.format(name)))
#
# print("mature") if age > 18 else print("kid")
list2 = ["asdf", "sdf"]
list1 = ["tarek", "barek", "mojek"]
list1.remove("tarek")
list1.append("ooo")
list1.insert(0, "o2o2")
print("tarek is in") if "tarek" in list1 else print("he is not in ")

# if "tarek" in list1:
#     print("tarek is in")
# else:
#     print("he is not in")
# print(list1)

thisdict = {
    "brand": "Ford",
    "model": "Mustang",
    "year": 1964
}
thisdict["color"] = "red"
print(thisdict)
thisdict.pop("model")
print(thisdict)
print(thisdict.values())
print(dict.fromkeys(thisdict))
print(thisdict["brand"])
