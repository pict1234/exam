#client side code

import sha1code	#import the code for sha1 algorithm 
import socket
clientsocket=socket.socket(socket.AF_INET,socket.SOCK_STREAM)	#create a unix domain, stream type client side socket

#get hostname of local machine
#host = socket.gethostname()
host = 'localhost'	#localhost
#assign port no.
port = 12345

clientsocket.connect((host, port))	#connect to localhost,port no. 
msg=raw_input("Enter message: ")
message_digest=sha1code.sha1(msg)
print "Message Digest Initial: ", message_digest


clientsocket.send(msg)	# send message to be encrypted to server
message_from_server=clientsocket.recv(1024)	#get message digest from server
		#compute message digest locally

newmd=sha1code.sha1(message_from_server)
print "Message Digest Final: ", newmd

if(message_digest == newmd):
	print("success")
else:
	print("failure")

