from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader


# Create your views here.
def test(request):
    template = loader.get_template('myFirst.html')
    return HttpResponse(template.render())


def test2(request):
    template = loader.get_template('myFirst.html')
    return HttpResponse(template.render())
