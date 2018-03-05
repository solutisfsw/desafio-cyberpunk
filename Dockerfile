FROM node:latest
RUN mkdir -p /usr/src/cyberpunk
WORKDIR /usr/src/cyberpunk
COPY package.json /usr/src/cyberpunk/
RUN npm install
COPY . /usr/src/cyberpunk
EXPOSE 3000
CMD [ "npm", "start" ]