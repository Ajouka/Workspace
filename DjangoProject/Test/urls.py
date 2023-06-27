from django.urls import path
from . import views

urlpatterns = [
    path('Test/', views.test, name='Test'),
    path('Test2/', views.test2, name='Test2'),
]
