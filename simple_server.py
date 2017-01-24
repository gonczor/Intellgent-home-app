#!/usr/bin/env python3

import socket
import sys

default_address = input('Give default address. Leave empty to set to 127.0.0.1')
if not default_address:
    default_address='127.0.0.1'

default_port = input('Give default port. Leave empty to set to 12345')
if not default_port:
    default_port = 12345
else:
    default_port = int(default_port)


server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print('Created socket: {}'.format(server_socket))
server_socket.bind((default_address, default_port))
print('Socket bound to {}:{}'.format(default_address, default_port))

server_socket.listen(5)
print('Server lsitening')
(client, addr) = server_socket.accept()
print('Listening on {}:{}'.format(default_address, default_port))

request = client.recv(1024)

print('Received: {}'.format(request))

if request == b'user pass':
    print('Sending ACK')
    client.send(b'ACK')
else:
    print('Closing down')
    client.close()
    sys.exit()

print('Receiving order')
request = client.recv(1024)
print('Received: {}'.format(request))
print('Resending data')
client.send(request)
client.close()
