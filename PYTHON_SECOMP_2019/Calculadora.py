def calculadora(num1, op, num2):
	if(op == 1):
		return float(num1 + num2)
	elif(op == 2):
		return float(num1 - num2)
	elif(op == 3):
		return float(num1 * num2)
	elif(op == 4):
		if(num2 != 0):
			return float(num1 / num2)
		else:
			return -1
	elif(op == 5):
		return float(num1 ** num2)
	elif(op == 6):
		return float(num1 ** (1.0 / num2))


while(True):
	op = input("\n\n  1 - soma\n  2 - subtracao\n  3 - multiplicacao\n  4 - divisao\n  5 - exponencial\n  6 - raiz\n  7 - sair\n\n  Insira a opcao: ")
	if(op == 7):
		print("\n\n\n")
		exit()
	num1 = float(input("\n\n  Insira um numero: "))
	num2 = float(input("\n\n  Insira outro numero: "))
	res = calculadora(num1, op, num2)
	print("\n\n  Resultado: %s" % res)

""" FALTOU HISTORICO.txt
